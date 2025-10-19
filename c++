#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
#include <algorithm>

// Represents a railway route or point of interest
struct RailwayRoute {
    std::string start;
    std::string end;
    std::string description;
};

// Manages information about Jetalsar
class JetalsarInfoSystem {
private:
    std::unordered_map<std::string, std::string> town_facts;
    std::vector<RailwayRoute> major_routes;

public:
    JetalsarInfoSystem() {
        town_facts["Location"] = "Rajkot District, Gujarat, India";
        town_facts["Primary Role"] = "Major Railway Junction (JTL)";
        town_facts["Significance"] = "Connects several major routes across the Saurashtra region.";

        major_routes.push_back({"Jetalsar", "Rajkot", "Key connection to the largest city and commercial center in the region."});
        major_routes.push_back({"Jetalsar", "Veraval", "Connects the junction to major pilgrimage centers like Somnath."});
        major_routes.push_back({"Jetalsar", "Porbandar", "Links the junction to the coastal city of Porbandar."});
    }

    void get_town_fact(const std::string& fact_name) const {
        if (town_facts.count(fact_name)) {
            std::cout << fact_name << ": " << town_facts.at(fact_name) << std::endl;
        } else {
            std::cout << "Fact not found: " << fact_name << std::endl;
        }
    }
    
    void search_routes(const std::string& destination) const {
        std::cout << "\n--- Search Results for routes to '" << destination << "' ---" << std::endl;
        bool found = false;
        std::string lower_dest = destination;
        std::transform(lower_dest.begin(), lower_dest.end(), lower_dest.begin(), ::tolower);

        for (const auto& route : major_routes) {
            std::string lower_end = route.end;
            std::transform(lower_end.begin(), lower_end.end(), lower_end.begin(), ::tolower);
            
            if (lower_end.find(lower_dest) != std::string::npos) {
                std::cout << "Route: " << route.start << " to " << route.end << std::endl;
                std::cout << "Description: " << route.description << std::endl;
                std::cout << "----------------------------------------" << std::endl;
                found = true;
            }
        }
        if (!found) {
            std::cout << "No major routes found to that destination." << std::endl;
        }
    }
};

int main() {
    JetalsarInfoSystem info_system;
    
    // Display general facts
    info_system.get_town_fact("Location");
    info_system.get_town_fact("Primary Role");

    // Search for routes
    info_system.search_routes("Rajkot");
    info_system.search_routes("Somnath"); // Search for city connected via Veraval route

    return 0;
}
