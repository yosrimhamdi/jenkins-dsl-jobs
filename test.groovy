job('mhamdi-test') {
    scm {
        git('https://github.com/yosrimhamdi/jenkins-ci-cd') {
            node / gitConfigName('Yosri Mhamdi')
            node / gitConfigEmail('yosri@mhamdi.co')
        }
    }
    triggers {
        githubPush()
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
        shell("npm test")
    }
}