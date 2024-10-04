
Monopoly Game OO-Design

This project is a design for a Monopoly game created as part of Assignment 2. The goal of this design is to prepare for the introduction of a computer player while spreading complexity across multiple classes to avoid a monolithic central class that manages everything. The design follows object-oriented principles and creates clear separations of responsibilities among various game components.

1. Build the project
```bash
./gradlew build
```
2. Run the project
```bash
./gradlew run -q --console=plain
```

Overview

This section describes the key classes that encapsulate the game’s behavior and rules. These are the central elements that drive the game’s logic.

Game Class

	•	Responsibilities:
	•	Initializes the game components including the board, dice, user interface (UI), and players.
	•	Manages the main game loop and rounds.
	•	Ensures players adhere to the rule where they must roll again if the dice have equal scores (i.e., rolling doubles).

HumanPlayer Class

	•	Responsibilities:
	•	Represents a human player interacting with the UI for decision-making and actions.
	•	Handles the movement of the player across tiles and manages the player’s funds.
	•	Implements the Player interface, designed to accommodate future enhancements like a computer-controlled player.

Tile Hierarchy

	•	Structure: Tiles are arranged in a circular doubly linked list where each tile references the next and previous tile.
	•	Behavior:
	•	Tiles receive specific messages when a player starts, passes over, or stops on a tile, triggering appropriate behavior.
	•	Tile subclasses define the rules for specific tiles, such as property tiles (buying property, paying rent) or the start tile (providing funds when passed).
	•	Additional tile types (e.g., Jail, Card tiles) can be added in future extensions.

Future Improvements

The design is prepared for future enhancements:

	1.	UI Decoupling:
	•	Introduce a messaging interface for the UI, allowing the HumanPlayer class to communicate through a more abstract interface. This makes it easier to switch to a different UI implementation.
	2.	Consolidating Player Logic:
	•	The payRent and deduceFunds operations in the Player class have overlapping functionality. Consider refactoring deduceFunds with parameters to reduce redundancy.
	3.	Computer Player:
	•	If adding a computer player introduces code duplication from HumanPlayer, consider creating an abstract PlayerBase class to consolidate shared functionality.
	4.	Tile Hierarchy Improvements:
	•	Move the Tile classes into their own package for better organization.
	•	Extend the tile hierarchy with additional subclasses for special tiles like Jail, Card tiles, etc.

Class Diagrams and Scenario Descriptions

Class Diagram

A diagram of the class structure outlining the relationships between the game components.

Move Player Scenario - Boris
This scenario illustrates how the system handles moving a player, following the scenario outlined in the assignment description.

Initial State Object Diagram

This diagram represents the initial state of the relevant objects involved in the scenario.

Sequence Diagram
This diagram shows the sequence of method calls made during the move operation for Boris. It focuses on the specific scenario described, though the implementation includes flexibility such as conditionals for other choices and loops for variable steps.

Property Buy Sequence Diagram

A sequence diagram showing the exact steps and method calls involved in a player buying a property.

Conclusion

This object-oriented design for the Monopoly game prepares the system for future enhancements like a computer player and more complex tile behaviors. By spreading responsibilities across multiple classes and adhering to solid design principles, the system remains flexible and extendable, supporting future development with minimal refactoring. The design promotes maintainability, clarity, and scalability, making it an ideal foundation for a Monopoly game.

Author

	•	Hao Chen
	•	Contact: hc222ig@student.lnu.se