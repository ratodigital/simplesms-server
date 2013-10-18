
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

// GOOGLE CLOUD MESSAGE (GCM)
get "/gcm/register", forward: "/gcm/register.groovy"
post "/gcm/register", forward: "/gcm/register.groovy"
get "/gcm/list", forward: "/gcm/list.groovy"
get "/gcm/unregister", forward: "/gcm/unregister.groovy"
get "/gcm/send", forward: "/gcm/send.groovy"
