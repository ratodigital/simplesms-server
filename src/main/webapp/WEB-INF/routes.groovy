
//get "/", forward: "/WEB-INF/pages/index.gtpl"

get "/favicon.ico", redirect: "/images/sms.png"

get "/", forward: "/WEB-INF/pages/index.gtpl"

get "/precos", forward: "/WEB-INF/pages/pricing.gtpl"

post "/login", forward: "/login.groovy"
get "/logout", forward: "/logout.groovy"

get "/logout", forward: "/logout.groovy"

get "/sms", forward: "/sms.groovy"
post "/send/sms", forward: "/smsSend.groovy"

get "/mensagens", forward: "/msg/listMessages.groovy"

// GROUPS
get "/grupos", forward: "/group/listGroup.groovy"
get  "/group/list",           forward:  "/group/listGroup.groovy"
get  "/group/add",            forward:  "/WEB-INF/pages/group.gtpl"
post "/group/insert",         forward:  "/group/insertGroup.groovy"
get  "/group/delete/@id",     forward:  "/group/deleteGroup.groovy?id=@id"
post "/group/update",         forward:  "/group/updateGroup.groovy"

get "/chosen", forward: "/WEB-INF/pages/chosen.gtpl"

// PHONES
get "/contatos", forward: "/contact/listContact.groovy"
get  "/contact/list",           forward:  "/contact/listContact.groovy"
get  "/contact/add",            forward:  "/contact/editContact.groovy"
post "/contact/insert",         forward:  "/contact/insertContact.groovy"
get  "/contact/edit/@id",       forward:  "/contact/editContact.groovy?id=@id"
get  "/contact/delete/@id",     forward:  "/contact/deleteContact.groovy?id=@id"
post "/contact/update",         forward:  "/contact/updateContact.groovy"

// GOOGLE CLOUD MESSAGE (GCM)
get "/dispositivos", forward: "/gcm/listDevices.groovy"
get "/gcm/list", forward: "/gcm/listDevices.groovy"
get "/gcm/register", forward: "/gcm/register.groovy"
post "/gcm/register", forward: "/gcm/register.groovy"
get "/gcm/unregister", forward: "/gcm/unregister.groovy"
get "/gcm/send", forward: "/gcm/send.groovy"
put "/gcm/messages/@id/sent", forward: "/gcm/messageSent.groovy?id=@id"
get "/gcm/messages/@id/sent", forward: "/gcm/messageSent.groovy?id=@id"
get "/gcm/messages/@id", forward: "/gcm/messages.groovy?id=@id"

