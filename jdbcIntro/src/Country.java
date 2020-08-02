public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
 //Bu yukardaki değişkenleri class oluşturduğumuzdan dolayı constructors'larla yönetebilmek için gerek getter, setter ile encapsulation gereği private yaptık.Bir alt satırda constructor yazıyoruz.

    public Country(String code,String name,String continent,String region) {
        this.code=code;
        this.name=name;
        this.continent=continent;
        this.region=region;

    }
}
