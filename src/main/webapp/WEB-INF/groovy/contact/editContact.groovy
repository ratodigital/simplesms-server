import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  
  request.contact = params.id ? new Contacts().get(params.id) : null
  
  request.groups = new Groups().list()
  
  forward '/WEB-INF/pages/contact.gtpl'
}

