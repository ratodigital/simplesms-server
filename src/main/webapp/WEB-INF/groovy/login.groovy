import groovy.json.*

def status = ""
def code = ""
def message = ""

if (params.email && params.password) {
    def usr = datastore.execute {
        select single password
        from 'user'
        where 'email' == params.email
    }
    if (usr == null) {
        status = "ERROR"
        code = "01"
        message = "USER NOT FOUND"
    } else {
        if (usr.password != params.password) {
            status = "ERROR"
            code = "02"
            message = "INVALID PASSWORD"
        } else {
            status = "OK"
            code = "00"
            message = "SUCCESS"
            memcache['userEmail'] = params.email
        }
    }
}

//TODO colocar login num log de eventos

def json = new JsonBuilder([status: status, code: code, message: message])
println JsonOutput.prettyPrint(json.toString())
