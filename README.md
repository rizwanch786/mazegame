# MazeGame
List of the commands accepted by the game:
go => moves the player from one location to other location, 
	use exits as parameter
	Syntax -- go <Direction>

quit => quits the game,
	no parameter required
	Syntax -- quit

move => moves the player from one location to other location, 
	use exits as parameter
	Syntax -- move <Direction>

look => looks around the player, with or without parameter, 
	can provided exit as parameter
	Syntax -- look <Direction> or look

list => gives the list of the items player holds,
	no parameters required
	Syntax -- list

get => collects new item, 
	give the name of the item as parameter
	Syntax -- get <Item name>

drop => drops the item from players bag, 
	give the name of the item player has as parameter
	Syntax -- drop <Item name> 

equip => wear/wield the item in the bag,
	give the name of the item player has as parameter
	Syntax -- equip <Item name> 

unequip => unwield the item player is wielding,
	give name of the item player wearing/welding as parameter
	Syntax -- unequip <Item name> 

purchase => buy an item from a vendor, 
	give name of item to buy as parameter
	Syntax -- buy <Item name> 

sell => sell an item to a vendor,
	give name of item to sell as parameter
	Syntax -- sell <Item name> 

status => gives the status of the maze,
	no parameter accepted
	Syntax -- status 

fight => to battle with the hostile character,
	give name of hostile character as parameter
	Syntax -- fight <Hostile Character name> 

stat => gets the statistics of player,
	no parameter accepted
	Syntax -- stat

help => gets the list of all the commands applicable,
	no parameter accepted
	Syntax -- help

This game has specific map you can change the map by modifying code as you like.

	---------------------------------------------------------------------------------------------
	------- | Cafeteria     | Management Office |---------|Table Tennis Room |Lab401    |--------
	---------------------------------------------------------------------------------------------
	--------|Staff Office   |-------------------| Library |------------------|Lecture301|--------
	---------------------------------------------------------------------------------------------
	--------|Board Room     |-------------------|Lab 201  | Lecture 202      | Lab203   |--------
	---------------------------------------------------------------------------------------------
	StartUp | Reception     |Lecture 101	    |------------------------------------------------
  
  You will start from startup and you can move diagonally or east,west,south,north if there are paths that way.
