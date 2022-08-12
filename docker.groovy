job('mhamdi-docker') {
    scm {
        git('https://github.com/yosrimhamdi/jenkins-ci-cd') {
            node / gitConfigName('Yosri Mhamdi')
            node / gitConfigEmail('yosri@mhamdi.co')
        }
    }
   triggers {
        buildResult('H/10 * * * *') {
            combinedJobs()
            triggerInfo('mhamdi-test', BuildResult.SUCCESS)
        }
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('yosrimhamdi/first-demo')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            registryCredentials('f4f99d61-e797-4425-b097-cc103942709b')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}