def buildapp(){
    echo 'Build is started'
	// bat "dotnet restore"
	// bat "\"${tool 'MS_Build_2022'}\\MSBuild.exe\" CnC_CMS.sln /p:Configuration=Release  /p:DeployOnBuild=true /p:DeployDefaultTarget=WebPublish /p:WebPublishMethod=FileSystem /p:DeleteExistingFiles=true  /p:publishUrl=C:\\Jenkins\\Publish\\abcd.pshealthpunjab.gov.pk"
    echo 'build is completed' 
}

def backupapp(){
    echo "Build Test is started for testing"
	bat '''
	echo "doing  Testing stuff"
	cd "c:\\windows\\system32\\inetsrv"
	appcmd stop sites "5555"
	'''
}

def deployapp(){

    echo 'deployment started on production server'
}

return this