def buildapp(){
    echo 'Build is started'
	bat "dotnet restore"
	bat "\"${tool 'MS_Build_2022'}\\MSBuild.exe\" CnC_CMS.sln /p:Configuration=Release  /p:DeployOnBuild=true /p:DeployDefaultTarget=WebPublish /p:WebPublishMethod=FileSystem /p:DeleteExistingFiles=true  /p:publishUrl=C:\\Jenkins\\Publish\\cms.pshealthpunjab.gov.pk"
    echo 'build is completed' 
}

def backupapp(){
    echo "Taking Backup before deployment"
	bat '''
	echo "Backup started"
	winrar a -r -ep1 -xc:\inetpub\wwwroot\MasterDetailCrud\ignore c:\inetpub\wwwroot\MasterDetailCrud\cbsl.zip c:\inetpub\wwwroot\MasterDetailCrud\*
    echo "Stopping the Site"
	cd C:\Windows\System32\inetsrv
    appcmd stop sites "testingweb"
	'''
}

def deployapp(){
	echo "Deploying Application"
    bat '''
	echo Deployment started
    robocopy /S /MT:5 "\\172.16.15.120\c$\Jenkins\Publish\cbsl.pshealthpunjab.gov.pk"  "c:\inetpub\wwwroot\MasterDetailCrud"
	echo Starting the Site
	cd C:\Windows\System32\inetsrv
    appcmd start sites "testingweb"
	'''
}

return this