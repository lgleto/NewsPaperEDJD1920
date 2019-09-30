package ipca.examples.newspaper.entities

import org.json.JSONObject

class Newspaper : BaseModel() {

    var description : String? = null
    var image       : Int?    = null

    override fun toJson(): JSONObject {
        val jsonObject = super.toJson()
        jsonObject.put("description", description)
        jsonObject.put("image", image)
        return jsonObject
    }
}
