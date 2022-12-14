job('mhamdi') {
    scm {
        git('https://github.com/yosrimhamdi/mhamdi') {
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
        dockerBuildAndPublish {
            repositoryName('yosrimhamdi/first-demo')
            registryCredentials('f4f99d61-e797-4425-b097-cc103942709b')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}