def gitUrl = "https://github.com/harishav/gradle_basics.git"

job("MyProject_Build") {
    description "Builds MyProject from master branch."
    parameters {
        stringParam('COMMIT', 'HEAD', 'Commit to build')
    }
    scm {
        git {
            remote {
                url gitUrl
                branch "origin/master"
            }
            extensions {
                wipeOutWorkspace()
                
            }
        }
    }
    steps {
       
        gradle {
            tasks('clean')
            tasks('build')
        }
 
    }
}
def mvnGitUrl = "https://github.com/harishav/reservation_client.git"

job("MyProject_Build1") {
    description "Creating one more MyProject from master branch."
    
    scm {
        git {
            remote {
                url mvnGitUrl
                branch "origin/master"
            }
            extensions {
                wipeOutWorkspace()
                
            }
        }
    }
    steps {
       
        maven {
            goals('clean')
            goals('install')
        }
 
    }
}
