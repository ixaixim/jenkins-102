def buildApp()  {
    echo 'Building...'
}

def testApp() {
    echo 'Testing...'
}

def deployApp() {
    echo 'Deploying app'
    echo 'Deployin version ${params.VERSION}'
}