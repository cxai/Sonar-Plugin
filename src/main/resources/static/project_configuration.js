window.registerExtension('checkmarx/project_configuration', function (options) {

    // let's create a flag telling if the static is still displayed
    var isDisplayed = true;

    var credentials;
    var isCxConnectionSuccessful;
    var sessionId;
    var projectsIn;
    var selectedProjectInSonarDb;

    var staticUrl = window.baseUrl +'/static/checkmarx';

    var configurationPage;
    
    if (isDisplayed) {

        loadCssFile();
        //clear page in case where the page was loaded, redirected and then redirected back
        options.el.textContent = '';


        var spanSpinner = getConnectingSpinner();
        options.el.appendChild(spanSpinner);

        getCxCredentialsResponse().then(function (res1) {
            return connectAndGetResponse(res1);
        }).then(function (res2) {
            return getCxProjectsFromServerResponse(res2);
        }).then(function (res3) {
            return getCxProjectFromSonarResponse(res3);
        }).then(function (res4) {
            //Session id is no longer necessary
            cleanConnection();
            options.el.removeChild(spanSpinner);
            return loadUI(res4);
        });
    }

    /*********************pre loading page************************************************/


    function loadCssFile() {
        var fileRef = document.createElement("link");
        fileRef.id = "perojectConfigCss";
        fileRef.rel = "stylesheet";
        fileRef.type = "text/css";
        fileRef.href = staticUrl+'/project_config_style.css';
        document.getElementsByTagName("head")[0].appendChild(fileRef)
    }

    function getConnectingSpinner(){
        var span = document.createElement('span');
        var h1 = document.createElement('h1');
        h1.textContent = "Connecting...";
        h1.id = "h1Connecting";
        span.appendChild(h1);
        var spinner = document.createElement('div');
        spinner.className = "spinner";
        spinner.id = "loadingSpinner";
        span.appendChild(spinner);
        return span;
    }

    /******************************************Build UI ****************************************************/

    function loadUI(response) {
        try {
            selectedProjectInSonarDb = response.settings[0].value;
        } catch(err){
            selectedProjectInSonarDb = "";
        }
        return new Promise(function () {

            var div = document.createElement('div');
            div.className = "configurationDiv";
            div.id = "configurationDivId";
            configurationPage = div;
            options.el.appendChild(configurationPage);
            createHeadline();
            createCredentialsForms();
            createTestConnectionButton();
            createProjectOptionsForm();
            createSaveButton();
        })
    }
    
    /*********************Headline****************************/

    function createHeadline() {
        var div = document.createElement('div');
        div.className = "header";
       var img = document.createElement('img');
        img.src = staticUrl+'/CxIcon48x48.png';
        div.appendChild(img);
        var h1 = document.createElement('h1');
        h1.textContent = "Checkmarx Configuration";
        div.appendChild(h1);
        var br = document.createElement("br");
        div.appendChild(br);
        configurationPage.appendChild(div);
    }


    /*********************Credentials*******************/

    function createCredentialsForms(){
        if(credentials != ""  && credentials != null) {
            var credentialsJson = JSON.parse(credentials);
            createInput('Server Url','text', 'serverUrl', credentialsJson.cxServerUrl);
            createInput('Username','text', 'username', credentialsJson.cxUsername);
            createInput('Password','password', 'password', credentialsJson.cxPassword);
        }else {
            createInput('Server Url','text', 'serverUrl', "");
            createInput('Username', 'text', 'username', "");
            createInput('Password','password', 'password', "");
        }
        createUrlDescription();
    }

    function createInput(labelText,inputType, id, value) {
        var paragraph = document.createElement("p");
        paragraph.id = id+'P';
        var label = createLabel(labelText);
        paragraph.appendChild(label);
        var input = document.createElement("INPUT");
        input.name = id;
        input.type = inputType;
        input.value = value;
        input.id = id;
        var errSpan = createErrSpan(id);
        paragraph.appendChild(input);
        paragraph.appendChild(errSpan);
        configurationPage.appendChild(paragraph);
    }

    function createUrlDescription() {
        var urlParagraph = document.getElementById('serverUrlP');
        var div = document.createElement('div');
        div.className = 'cxDescription';
        div.textContent = 'Syntax: http(s)://server-name(:port)';
        urlParagraph.appendChild(div);
    }
    

    /***************Test Connection**********************/

    function createTestConnectionButton() {
        var paragraph = document.createElement("p");
        paragraph.id = 'testConParagraph';
        var btn = document.createElement("BUTTON");// Create a <button> element
        btn.id = 'testConBtn';
        var t = document.createTextNode("Test Connection");       // Create a text node
        btn.appendChild(t);// Append the text to <button>
        btn.onclick =  function() {testConnection()};
        var spanSpinner = createSpan(btn.id);
        var spanErr = createErrSpan(btn.id);
        var spanSuccess = createSuccessSpan(btn.id);
        paragraph.appendChild(btn);
        paragraph.appendChild(spanSpinner);
        paragraph.appendChild(spanErr);
        paragraph.appendChild(spanSuccess);
        configurationPage.appendChild(paragraph);
    }

    function testConnection() {
        clearButtonsAndProjectListMsgs();
        createSpanSpinner('testConBtn');

        var credentialsToSend = getInputCredentialsAndValidateValues();
        if (credentialsToSend != "") {
            connectWithInputCredentialsAndGetResponse(credentialsToSend).then(function (res2) {
                return getCxProjectsFromServerResponse(res2)
            }).then(function (res3) {
                deleteSpanSpinner('testConBtn');
                return cleanUpAndUpdateUI(res3);
            });
        } else {//err msg appears in projects form
            deleteSpanSpinner('testConBtn');
        }
    }

    function cleanUpAndUpdateUI(response) {
        try {
            projectsIn = JSON.parse(response.projects);
            if (response.isSuccessful) {
                createSuccessMsg('testConBtn', 'Connection Successful');
            }else {
                createFailureMsg('testConBtn','Connection Failed');
            }
        } catch(err){
            projectsIn = "";
            createFailureMsg('testConBtn','Connection Failed');
        }
        return new Promise(function () {
            //Session id is no longer necessary
            cleanConnection();

            var select = document.getElementById('projectSelect');
            select.innerHTML = createOptions();
        })
    }


    /**********Projects Drop Down List*******************************/

    function createProjectOptionsForm() {
        var paragraph = document.createElement("p");
        var form = document.createElement("FORM");
        form.id = 'projectForm';
        var label = createLabel('Checkmarx Project');
        form.appendChild(label);
        var select = document.createElement("SELECT");
        select.id = 'projectSelect';
        select.innerHTML = createOptions();
        form.appendChild(select);
        var errSpan = createErrSpan(form.id);
        paragraph.appendChild(form);
        paragraph.appendChild(errSpan);
        configurationPage.appendChild(paragraph);
    }


    function createOptions() {
        if (isCxConnectionSuccessful == false || projectsIn == "" || projectsIn == null) {
            return '<option value=\"">Unable to connect to server. Make sure URL and Credentials are valid to see project list.</option>';
        }

        var trueSelected = getAndValidateSelectedProjectToPresent();
        var options = '<option value=\"'+trueSelected[0]+'\">'+trueSelected[1]+'</option>';
        for (i=0; i<projectsIn.length ; ++i){
            if(projectsIn[i] != trueSelected[0])
                options = options + '<option value=\"'+projectsIn[i]+'\">'+projectsIn[i]+'</option>';
        }
        return options;
    }

    //will return the project to be presented as selected the project option list
    function getAndValidateSelectedProjectToPresent() {
        var selectedProjectInUi = getSelectedProjectInUI();
        if(selectedProjectInUi != "" && projectsIn.includes(selectedProjectInUi)){
            return [selectedProjectInUi, selectedProjectInUi];
        }else if(selectedProjectInSonarDb != "" && projectsIn.includes(selectedProjectInSonarDb)){
            return [selectedProjectInSonarDb,selectedProjectInSonarDb];
        }else{
            return ["","- Select -"];
        }
    }


    /********************************Save***************************/

    function createSaveButton() {
        var paragraph = document.createElement("p");
        var btn = document.createElement("BUTTON");// Create a <button> element
        btn.id = 'saveBtn';
        var t = document.createTextNode("Save");       // Create a text node
        btn.appendChild(t);// Append the text to <button>
        btn.onclick =  function() {save()};
        var spanSpinner = createSpan(btn.id);
        var spanErr = createErrSpan(btn.id);
        var spanSuccess = createSuccessSpan(btn.id);
        paragraph.appendChild(btn);
        paragraph.appendChild(spanSpinner);
        paragraph.appendChild(spanErr);
        paragraph.appendChild(spanSuccess);
        configurationPage.appendChild(paragraph);
    }

    function save() {

        clearButtonsAndProjectListMsgs();
        createSpanSpinner('saveBtn');

        var credentialsToSave = getInputCredentialsAndValidateValues();
        var projectToSave = getAndValidateProjectToSave();

        if(credentialsToSave != "" && projectToSave != "") {
            saveCxProject(projectToSave).then(function () {
                selectedProjectInSonarDb = projectToSave;
                return saveCxCredentials(credentialsToSave);
            }).then(function () {
                try {
                deleteSpanSpinner('saveBtn');
                }catch(err){}
                createSuccessMsg('saveBtn','Save Successful')
            }).catch(function (error) {
                try {
                    deleteSpanSpinner('saveBtn');
                }catch(err){}
                var msg = "Save failed due to SonarQube error " + error.response.statusText;
                createFailureMsg('saveBtn', msg);
            });
        } else {//err msg appears in projects form
            deleteSpanSpinner('saveBtn');
        }
    }




    /*********************Create\Delete Sub Elements*****************************************************************/

    function createLabel(labelText) {
        var label = document.createElement("label");
        label.textContent = labelText;
        return label;
    }

    function createSpan(id) {
        var span = document.createElement('span');
        span.id = id+'Span';
        return span;
    }

    function createSpanSpinner(id) {
        var spinner = document.createElement('div');
        spinner.className = "spinner";
        spinner.id = id+'Span'+'Spinner';
        var spanId = id+'Span';
        var span = document.getElementById(spanId);
        span.appendChild(spinner);
    }

    function deleteSpanSpinner(id) {
        var spinnerId = id+'Span'+'Spinner';
        var spinner= document.getElementById(spinnerId);
        var spanId = id+'Span';
        var span= document.getElementById(spanId);
        span.removeChild(spinner);
    }

    function createErrSpan(id) {
        var errSpan = document.createElement("span");
        errSpan.id = id+'Err';
        return errSpan;
    }

    function createSuccessSpan(id) {
        var errSpan = document.createElement("span");
        errSpan.id = id+'Success';
        return errSpan;
    }

    function eraseFailureMsg(id) {
        var errSpan = document.getElementById(id+'Err');
        errSpan.textContent = "";
    }
    function createFailureMsg(id, msg) {
        var errSpan = document.getElementById(id+'Err');
        errSpan.textContent = msg;
    }

    function eraseSuccessMsg(id) {
        var successSpan = document.getElementById(id+'Success');
        successSpan.textContent = "";
    }

    function createSuccessMsg(id, msg) {
        var successSpan = document.getElementById(id+'Success');
        successSpan.textContent = msg;
    }

    function clearButtonsAndProjectListMsgs() {
       try{
           //delete unnecessary spinner the user press test connection multiple times
           deleteSpanSpinner('testConBtn');
       }catch(err){}
        eraseSuccessMsg('testConBtn');
        eraseFailureMsg('testConBtn');

        try {
            //delete unnecessary spinner the user press save multiple times
            deleteSpanSpinner('saveBtn');
        }catch(err){}
        eraseFailureMsg('saveBtn');
        eraseSuccessMsg('saveBtn');

        eraseFailureMsg('projectForm');
    }


    /************************Validations and Retrievals*****************************************************************/

    //returns empty string if credentials are not valid
    function getInputCredentialsAndValidateValues(){
        var server = document.getElementById('serverUrl');
        var serverValue = server.value;
        var isServerValid = validateUrl('serverUrl', serverValue);
        var username = document.getElementById('username');
        var usernameValue = username.value;
        var isUsernameInput = validateInputHasValue('username', usernameValue);
        var password = document.getElementById('password');
        var passwordValue = password.value;
        var isPasswordInput = validateInputHasValue('password', passwordValue);
        if(isServerValid && isUsernameInput && isPasswordInput) {
            return parseCredentials(serverValue, usernameValue, passwordValue);
        }else {
            return "";
        }
    }

    function validateUrl(id, inputValue) {
        var isInput = validateInputHasValue(id, inputValue);
        if(isInput){
            var isUrl = isURL(inputValue);
            if(isUrl){
                return true;
            }
            var errSpan = document.getElementById(id+'Err');
            errSpan.textContent = 'Invalid URL';
        }
        return false;
    }

    function validateInputHasValue(id, inputValue){
        return validateInputCostumeErrMsg(id, inputValue, 'content must not be empty');
    }

    //returns empty String if there is no valid project to save
    function getAndValidateProjectToSave() {
        var selectedItem = getSelectedProjectInUI();
        var isValidProject = validateInputCostumeErrMsg('projectForm', selectedItem, 'Please choose a project from the list');
        if(isValidProject){
            return selectedItem;
        }
        return "";
    }

    function getSelectedProjectInUI() {
        try{
            var projectSelect  = document.getElementById('projectSelect');
            var selectedIdx = projectSelect.selectedIndex;
            return projectSelect.options[selectedIdx].value;
        }catch (err){
            return "";
        }
    }

    function validateInputCostumeErrMsg(id, inputValue, msg){
        var errSpan = document.getElementById(id+'Err');
        if(inputValue == ""){
            errSpan.textContent = msg;
            return false;
        }
        errSpan.textContent = "";
        return true;
    }

    /****************************Helper Functions****************************************************************/

    function parseCredentials(cxServerUrl, cxUsername, cxPassword) {
        return "{\"cxServerUrl\":\""+cxServerUrl+"\", \"cxUsername\": \""+cxUsername+"\", \"cxPassword\": \""+cxPassword+"\"}";
    }

    function isURL(str) {

        //test protocol
        if(!/^(f|ht)tps?:\/\//i.test(str)){
            return false;
        }

        //test entire string form
        var pattern = new RegExp('^(https?:\\/\\/)?'+ // protocol
            '((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.?)+[a-z]{2,}|'+ // domain name
            '((\\d{1,3}\\.){3}\\d{1,3}))'+ // OR ip (v4) address
            '(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*'+ // port and path
            '(\\?[;&a-z\\d%_.~+=-]*)?'+ // query string
            '(\\#[-a-z\\d_]*)?$','i'); // fragment locator
        return pattern.test(str);
    }

    /*************************************************REST Requests****************************************************/

    /*****************Checkmarx server***************/

    function connectAndGetResponse(response) {
        try{
            credentials = response.settings[0].value;
        }catch (err){
            credentials = "";
        }
        return window.SonarRequest.postJSON('/api/checkmarx/connect', {
            resolved: false,
            component: options.component.key,
            credentials: credentials
        })
    }

    function connectWithInputCredentialsAndGetResponse(inserted) {
        credentials = inserted;
        return window.SonarRequest.postJSON('/api/checkmarx/connect', {
            resolved: false,
            component: options.component.key,
            credentials: credentials
        })
    }

    function getCxProjectsFromServerResponse(response) {
        try{
            sessionId = response.sessionId;
            isCxConnectionSuccessful = response.isSuccessful;
        }catch(err){
            sessionId = "";
            isCxConnectionSuccessful = 'false';
        }
        return window.SonarRequest.postJSON('/api/checkmarx/projects', {
            resolved: false,
            key: "checkmarx.server.credentials.secured",
            sessionId: sessionId
        })
    }

    function cleanConnection() {
        window.SonarRequest.postJSON('/api/checkmarx/clean_connection', {
            resolved: false,
            //identify current project
            component: options.component.key,
            sessionId: sessionId
        });
    }


    /***********sonar DB***************/

    function getCxProjectFromSonarResponse(response) {
        try {
            projectsIn = JSON.parse(response.projects);
        }catch (err){
            projectsIn = "";
        }
        return getSonarSettingResponse("checkmarx.server.project_name.secured")
    }

    function getCxCredentialsResponse() {
        return getSonarSettingResponse("checkmarx.server.credentials.secured")
    }

    function getSonarSettingResponse(key) {
        return window.SonarRequest.getJSON('/api/settings/values', {
            resolved: false,
            keys: key,
            component: options.component.key
        })
    }

    function saveCxProject(cxProject) {
        return window.SonarRequest.post('/api/settings/set', {
            resolved: false,
            key: "checkmarx.server.project_name.secured",
            value: cxProject,
            component: options.component.key
        })
    }

    function saveCxCredentials(cxCredentials) {
        return window.SonarRequest.post('/api/settings/set', {
            resolved: false,
            key: "checkmarx.server.credentials.secured",
            value: cxCredentials,
            component: options.component.key
        })
    }

    /*****************************************************************************************************************/

    //Sonar documentation says this runs when the page closes, but as of 6.3 this has no effect
  return function () {
      isDisplayed = false;
  };

});