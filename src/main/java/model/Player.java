package model;

public class Player {
    int id;
    String Firstname;
    String Lastname;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstname()
    {
        return Firstname;
    }

    public void setFirstname(String firstname)
    {
        Firstname = firstname;
    }

    public String getLastname()
    {
        return Lastname;
    }

    public void setLastname(String lastname)
    {
        Lastname = lastname;
    }
}
