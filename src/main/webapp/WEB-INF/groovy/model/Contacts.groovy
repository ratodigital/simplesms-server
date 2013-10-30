package model

import com.google.appengine.api.datastore.*
import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key
import groovyx.gaelyk.GaelykBindings
import util.*

@GaelykBindings
public class Contacts {

  def get(id) {
    def longId = Long.parseLong(id)
    Key key = KeyFactory.createKey("contact", longId)
    def goal = datastore.get(key)
  }
  
	def list() {
		def userEmail = memcache['userEmail']
		datastore.execute {
	  	select all
	 	 	from contact
			where email == userEmail
			sort asc by name
  	}
	}

	def listByGroup(group) {
		def userEmail = memcache['userEmail']
		datastore.execute {
	  	select all
	 	 	from contact
			where email == userEmail
			and groups == group
			sort asc by name
  	}
	}

  def countByGroup(group) {
		def userEmail = memcache['userEmail']
		datastore.execute {
	  	select count
	 	 	from contact
			where email == userEmail
			and groups == group
  	}
  } 
  
	def delete(id) {
		Key key = KeyFactory.createKey("contact", Long.parseLong(id))
		key.delete()
	}

  def update(id, name, phone, groups) {
    def e = get(id)  
    e.name = name
    e.phone = phone    
    e.groups = prepareGroups(groups)
    e.save()	
  }

	def add(name, phone, groups) {
    def e = new Entity("contact")
		e.email = memcache['userEmail']
    e.name = name
    e.phone = phone
    e.groups = prepareGroups(groups)
    e.dateCreated = (new Clock()).getDateTime()
    e.save()	
	}

  private def prepareGroups(groups) {
    if (groups == null) {
        return null
    } else if (groups instanceof String) {
        return [groups]
    } else if (groups) {
        return groups.toList()
    }  
  }
}
