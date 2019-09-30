package ipca.examples.newspaper.entities

import org.json.JSONObject

interface JsonProtocol {

    fun toJson () : JSONObject
}