# Duke User Guide

## Table of Contents
* Introduction
* Quick Start
* Features
    * [Adding a 'todo' task](#adding-a-todo-task-todo): `todo`
    * [Adding a 'deadline' task](#adding-a-deadline-task-deadline): `deadline`
    * [Adding an 'event' task](#adding-an-event-task-event): `event`
    * [Displaying all task in the list](#displaying-all-task-in-the-list-list): `list`
    * [Marking a task as done](#marking-a-task-as-done-done): `done`
    * [Deleting a task from the list](#deleting-a-task-from-the-list-delete): `delete`
    * [Finding tasks by entering a keyword](#finding-tasks-by-entering-a-keyword-find): `find`
    * [Displaying the help commands](#displaying-the-help-commands-help): `help`
    * [Saving data into a text file](#saving-data-into-a-text-file-bye): `bye`
    * [Exiting Duke](#exiting-duke-bye): `bye`
* Command Summary

## Introduction 
Duke is a Command-Line-Interface (CLI) based task management application which caters for University students who
require help in organizing their tasks such as todo, deadline and events systematically. 

## Quick start

1. Java 11 is required and ensure Intellij is updated to the most recent version.

2. Download the latest duke.jar file from GitHub and place it into an empty folder

3. Type `cmd` in the address bar of File Explorer which contains the duke.jar file and press `Enter`. 
Command prompt will open. 

4. Run command `java -jar duke.jar`

5. Refer to the section on Features for the commands and its uses.

## Features

* There are 3 types of task: `todo`, `deadline` and `event`.
* The rest of the commands are `list`, `done`, `delete`, `find`, `help`, `bye`.

**Take note:**

    1. All commands entered by user are case-sensitive.  
    2. Enter the `help` command to view the correct format for each input.
    3. Ensure to save all data before exiting the application by entering the `bye` command. There is **NO** autosave functionality.
    4. Command entered by user will have parameters appearing in `**UPPER_CASE**`.
    
    
### Adding a 'todo' task: `todo`

Function: Adds a task type called todo into the list.

Format:  `todo **TASK_DESC**`

Example: `todo finish README.md`

**Take note:**

    Parameter **TASK_DESC** cannot be empty. 
    
### Adding a 'deadline' task: `deadline`    

Function: Adds a task type called deadline into the list.

Format:  `deadline **TASK_DESC /by DATE_TIME**`

Example: `deadline finish README.md /by Friday`

**Take note:**

    Parameter **TASK_DESC /by DATE_TIME** cannot be empty.
    
### Adding an 'event' task: `event`   

Function: Adds a task type called event into the list.

Format:  `event **TASK_DESC /at DATE_TIME**`

Example: `event dinner with friends /at Friday 2nd Oct 2020 19:30`

**Take note:**

    Parameter **TASK_DESC /at DATE** cannot be empty.
 
### Displaying all task in the list: `list`

Function: Prints out the list of tasks added.

Format: `list`

Example: `list`

### Marking a task as done: `done`

Function: Marks the task which is specified by a number, as done.

Format: `done **TASK_NUM**`

Example: `done 2` 

**Take note:**

    1. Parameter **TASK_NUM** cannot be empty.
    2. Parameter **TASK_NUM** must exist in the list. 

### Deleting a task from the list: `delete`

Function: Deletes a task which is specified by a number, from the list. 

Format: `delete **TASK_NUM**`

Example: `delete 3 `

**Take note:**

    1. Parameter **TASK_NUM** cannot be empty.
    2. Parameter **TASK_NUM** must exist in the list.
    
### Finding tasks by entering a keyword: `find`

Function: Finds and displays all tasks whose description matches the keyword.

Format: `find **KEYWORD**`

Example: `find book`

**Take note:**

    Parameter **KEYWORD** cannot be empty.

### Displaying the help commands: `help`

Function: Shows user the valid commands and their format. 

Format: `help`

Example: `help`

### Saving data into a text file: `bye`

Function: Saves all changes made into duke.txt 

Format: `bye`

Example: `bye`

### Exiting Duke: `bye`

Function: Exits duke application

Format: `bye`

Example: `bye`

## Command Summary

Function    | Format, | Example 
---------- | ----------  | ----------            
Todo | `todo **TASK_DESC**`| `todo finish README.md` 
Deadline | `deadline **TASK_DESC** /by DATE_TIME`| `deadline finish README.md /by Friday`
Event | `event **TASK_DESC /at DATE_TIME**` | `event dinner with friends /at Friday 2nd Oct 2020 19:30`
List | `list` | `list`
Done | `done **TASK_NUM**`| `done 2`
Delete | `delete **TASK_NUM**` | `delete 3`
Find | `find **KEYWORD**`| `find book`
Help | `help` | `help`
Save | `bye` | `bye`
Exit | `bye` | `bye`

## End of Duke User Guide
