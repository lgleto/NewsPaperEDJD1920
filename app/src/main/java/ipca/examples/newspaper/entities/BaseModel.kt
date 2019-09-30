package ipca.examples.newspaper.entities

import org.json.JSONObject

open class BaseModel : JsonProtocol {

    var id      : Int?    = null
    var title   : String? = null

    override fun toJson(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("id", id)
        jsonObject.put("title", title)
        return jsonObject
    }

}