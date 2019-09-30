package ipca.examples.newspaper.entities

import org.json.JSONObject

class Category : BaseModel() {

    var image : Int? = null

    override fun toJson(): JSONObject {
        val jsonObject = super.toJson()
        jsonObject.put("image", image)
        return  jsonObject
    }
}
