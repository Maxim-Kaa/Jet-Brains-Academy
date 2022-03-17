
class Employee {

    protected  String name;
    protected  String  email;
    protected  int experience;
    // write fields

    protected Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    // write constructor

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }
    // write getters
}

class Developer extends Employee {
    protected  String mainLanguage;
    protected  String[] skills;
    // write fields

    protected  Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills.clone();
    }
    // write constructor

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String[] getSkills() {
        return skills.clone();
    }
    // write getters
}

class DataAnalyst extends Employee {

    protected boolean phd;
    protected  String[] methods;
    // write fields

    protected DataAnalyst(String name, String email, int experience, boolean phd, String[] methods) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = methods.clone();
    }
    // write constructor


    public boolean isPhd() {
        return phd;
    }

    public String[] getMethods() {
        return methods.clone();
    }
}