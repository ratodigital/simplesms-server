
//get "/", forward: "/WEB-INF/pages/index.gtpl"

get "/favicon.ico", redirect: "/images/certificado.png"

get "/", forward: "/WEB-INF/pages/index.gtpl"
get "/pdf", forward: "/WEB-INF/pages/pdf.gtpl"
get "/email", forward: "/WEB-INF/pages/email.gtpl"
get "/upload", forward: "/upload.groovy"
post "/upload", forward: "/upload.groovy"
get "/success", forward: "/WEB-INF/pages/success.gtpl"
get "/failure", forward: "/WEB-INF/pages/failure.gtpl"

get "/precos", forward: "/WEB-INF/pages/pricing.gtpl"

post "/login", forward: "/login.groovy"
get "/logout", forward: "/logout.groovy"

get "/logout", forward: "/logout.groovy"

get "/sms", forward: "/sms.groovy"
post "/sms/send", forward: "/smsSend.groovy"

get "/telefones", forward: "/tel/listTel.groovy"
get  "/tel/list",           forward:  "/tel/listTel.groovy"
get  "/tel/add",            forward:  "/WEB-INF/pages/tel.gtpl"
post "/tel/insert",         forward:  "/tel/insertTel.groovy"
get  "/tel/delete/@id",     forward:  "/tel/deleteTel.groovy?id=@id"
get  "/tel/edit/@id",       forward:  "/tel/editTel.groovy?id=@id"
post "/tel/update",         forward:  "/tel/updateTel.groovy"

// GOOGLE CLOUD MESSAGE (GCM)
get "/dispositivos", forward: "/gcm/listDevices.groovy"
get "/gcm/list", forward: "/gcm/listDevices.groovy"
get "/gcm/register", forward: "/gcm/register.groovy"
post "/gcm/register", forward: "/gcm/register.groovy"
get "/gcm/unregister", forward: "/gcm/unregister.groovy"
get "/gcm/send", forward: "/gcm/send.groovy"
get "/gcm/messages", forward: "/gcm/messages.groovy"
