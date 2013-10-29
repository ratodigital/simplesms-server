package model

import com.google.appengine.api.datastore.*
import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key
import groovyx.gaelyk.GaelykBindings
import util.*

@GaelykBindings
public class Phones {

  def get(id) {
    def longId = Long.parseLong(id)
    Key key = KeyFactory.createKey("phone", longId)
    def goal = datastore.get(key)
  }
  
	def list() {
		def userEmail = memcache['userEmail']
		datastore.execute {
	  	select all
	 	 	from phone
			where email == userEmail
			sort asc by name
  	}
	}

	def delete(id) {
		Key key = KeyFactory.createKey("phone", Long.parseLong(id))
		key.delete()
	}

  def update(id, number, name, groups) {
    def e = get(id)  
    e.number = number
    e.name = name
    e.groups = prepareGroups(groups)
    e.save()	
  }

	def add(number, name, groups) {
    def e = new Entity("phone")
		e.email = memcache['userEmail']
    e.number = number
    e.name = name
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
