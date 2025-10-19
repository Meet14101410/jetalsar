import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Represents a railway route originating from Jetalsar
class RailwayRoute {
    private String start;
    private String end;
    private String description;

    public RailwayRoute(String start, String end, String description) {
        this.start = start;
        this.end = end;
        this.description = description;
    }

    public String getStart() { return start; }
    public String getEnd() { return end; }

    @Override
    public String toString() {
        return "Route: " + start + " to " + end + "\nDescription: " + description;
    }
}

// Manages information about Jetalsar
public class JetalsarInfoSystem {
    private Map<String, String> townFacts;
    private List<RailwayRoute> majorRoutes;

    public JetalsarInfoSystem() {
        townFacts = new HashMap<>();
        townFacts.put("Location", "Rajkot District, Gujarat, India");
        townFacts.put("Primary Role", "Major Railway Junction (JTL)");
        townFacts.put("Significance", "Connects several major routes across the Saurashtra region.");

        majorRoutes = new ArrayList<>();
        majorRoutes.add(new RailwayRoute("Jetalsar", "Rajkot", "Key connection to the largest city and commercial center in the region."));
        majorRoutes.add(new RailwayRoute("Jetalsar", "Veraval", "Connects the junction to major pilgrimage centers like Somnath."));
        majorRoutes.add(new RailwayRoute("Jetalsar", "Porbandar", "Links the junction to the coastal city of Porbandar."));
    }

    public void getTownFact(String factName) {
        if (townFacts.containsKey(factName)) {
            System.out.println(factName + ": " + townFacts.get(factName));
        } else {
            System.out.println("Fact not found: " + factName);
        }
    }

    public void searchRoutes(String destination) {
        System.out.println("\n--- Search Results for routes to '" + destination + "' ---");
        boolean found = false;
        String lowerSearchTerm = destination.toLowerCase();

        for (RailwayRoute route : majorRoutes) {
            // Check if search term matches the end city (case-insensitive)
            if (route.getEnd().toLowerCase().contains(lowerSearchTerm)) {
                System.out.println(route.toString());
                System.out.println("----------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No major routes found to that destination.");
        }
    }

    public static void main(String[] args) {
        JetalsarInfoSystem infoSystem = new JetalsarInfoSystem();
        
        infoSystem.getTownFact("Primary Role");
        infoSystem.getTownFact("Significance");

        infoSystem.searchRoutes("Veraval");
        infoSystem.searchRoutes("Rajkot");
    }
}
