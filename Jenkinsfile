@Library('alternate-lib@master') _

node {
    // Clean workspace before doing anything
    deleteDir()
    //Chekout pipeline repo
    checkout scm

    customPipeline {
        publish = false
    }
}
