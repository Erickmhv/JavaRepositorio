public class Menu {
    private int Id;
    private String Description;

    public int getId() {
        return Id;
    }

    public String getDescription() {
        return Description;
    }

    public Menu (int id, String description)
    {
        Id = id;
        Description = description;
    }
}
