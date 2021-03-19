
package model;

/**
 *
 * @author Lucas Sales
 */
public class Pokemon {
    private String name;
    private String type;
    private int power;
    private String path;
    
    public Pokemon(String name, String type, int power, String path) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
}
