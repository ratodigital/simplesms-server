package model

import com.google.appengine.api.datastore.*
import groovyx.gaelyk.GaelykBindings
import util.*

@GaelykBindings
public class Devices {
	def list() {
		def userEmail = memcache['userEmail'] 
  	datastore.execute {
			select regId:String, name:String
			from device
			where email == userEmail
		}
	}	

	def getEmailByDeviceId(deviceId) {
		datastore.execute {
	    select single email
	    from device
	    where regId == deviceId
    }
	}

	def deviceNameExists(userEmail, deviceName) {
		def count = datastore.execute {
      select count
      from device
      where name == deviceName
			and email == userEmail 
	   }
		count > 0
	}

	def add(regId, name) {
    def e = new Entity("device")
    e.regId = regId
    e.name = name      
		e.email = memcache['userEmail']
    e.dateCreated = (new Clock()).getDateTime()
    e.save()	
	}
}
