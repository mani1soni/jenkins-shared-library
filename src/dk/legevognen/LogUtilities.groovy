package dk.legevognen

class LogUtilities {

    def script

    LogUtilities(pipelineScript) {
        script = pipelineScript
    }
    
    void info(String message="") {
        script.echo("[\u001B[1;34mINFO\u001B[0m] ${message}")
    }

    void warning(String message="") {
        script.echo("[\u001B[1;33mWARNING\u001B[0m] ${message}")
    }

    void severe(String message="") {
        script.echo("[\u001B[1;31mSEVERE\u001B[0m] ${message}")
    }

    void debug(String message="") {
        if(script.env.JENKINSFILE_DEBUG) {
            script.echo("[\u001B[1;32mDEBUG\u001B[0m] ${message}")
        }
    }
}