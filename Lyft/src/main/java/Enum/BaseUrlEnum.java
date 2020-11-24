package Enum;

public enum BaseUrlEnum {

    getId("ip"),
    getUuid("uuid"),
    post("post"),
    put("put");

    private String resource ;

    BaseUrlEnum(String resource)
    {
        this.resource = resource;
    }

    public String getResource()
    {
        return resource;
    }

}
