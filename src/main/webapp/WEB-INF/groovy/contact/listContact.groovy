import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  if (params.group) {
    request.contacts = new Contacts().listByGroup(params.group)
  } else {
    request.contacts = new Contacts().list()
  }
  
  def groups = []
  new Groups().list().each { g ->
    groups << [name:g.name, value: new Contacts().countByGroup(g.name)]
  }
  request.groups = groups
  
  request.group = params.group
  
  forward '/WEB-INF/pages/contacts.gtpl'
}
