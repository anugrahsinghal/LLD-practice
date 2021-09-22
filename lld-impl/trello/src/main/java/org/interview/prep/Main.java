package org.interview.prep;


/*
The app contains multiple boards to signify different projects
Each board contains different lists to signify sub-project
Each list contain different cards signifying smaller tasks
Each card can be assigned to a user or may remain unassigned
Requirements
User: Each user should have a userId, name, email.
Board: Each board should have a id, name, privacy (PUBLIC/PRIVATE), url, members, lists
List: Each list should have a id, name and cards
Card: Each card should have a id, name, description, assigned user



--We should be able to create/delete boards,
--Deleting a board should delete all lists inside it.
add/remove people from the members list and modify attributes.

We should be able to create/delete lists and modify attributes.
Deleting a list should delete all cards inside it.

We should be able to create/delete cards, assign/unassign a member to the card and modify attributes
We should also be able to move cards across lists in the same board
Ability to show all boards, a single board, a single list and a single card
Default privacy should be public
Cards should be unassigned by default
--Ids should be auto-generated for board/list/card
== done URLs should get created based on the id

// OPTIONAL
Ability to clone a list with all the cards in it. All of these should have a different id.
Ability to delete all the cards in a list without deleting the list.
Option to add tags to a card and ability to get cards based on assigned tags.
Ability to find all the cards assigned to a particular user.


*/
/*
Input
You can create a few users in your main method. No need to take it as input.
There will be different types of input:
BOARD CREATE
BOARD <name/privacy>
BOARD <ADD_MEMBER/REMOVE_MEMBER>
BOARD DELETE
LIST CREATE
LIST
LIST DELETE
CARD CREATE
CARD <name/description>
CARD ASSIGN
CARD UNASSIGN
CARD MOVE
CARD DELETE
SHOW
SHOW BOARD
SHOW LIST
SHOW CARD
If you want you create these in the main method without taking user input.
Output
CREATE operations should print the id after creation
SHOW should print all the boards with all the lists inside them and all the cards inside all the lists (including all the attributes)
SHOW <BOARD/LIST> should print that specific entity and everything inside it (including all the attributes)
SHOW CARD should print all the attributes of the card
You can use any format to print these. Printing in json is not compulsory.
 */
public class Main {
	public static void main(String[] args) {
		// multiple Boards - A Board is a Project
		// Project - List of subproject/ lists
		// SubProject - List of Cards or Tasks
		// Card will have a user assigned to it - default is non assigned


//		User: userId, name, email.
//		Project/Board: id, name, privacy (PUBLIC/PRIVATE), url, members, lists
//		SubProject/List: id, name and cards
//		Card: id, name, description, assigned user

	}
}
