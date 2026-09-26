# Android Registration App

An Android registration application developed as part of a developer assignment.

## Overview

This application allows users to enter their personal information through a registration form and displays the submitted information on a second screen.

The application also stores registered users in an in-memory Kotlin Array/List and displays all stored users in a table.

## Features

- User registration form
- Full Name input
- Date of Birth selection using DatePicker
- Gmail email validation
- Input validation
- Activity-to-Activity data transfer using Intent
- Multiple user registration
- User data stored using Kotlin MutableList
- Displays all registered users in a table
- Register Another User functionality
- Clean and responsive UI

## Technologies Used

- Kotlin
- Android Studio
- Android SDK
- XML
- Android Activities
- Intent
- DatePickerDialog
- MutableList
- ConstraintLayout
- TableLayout

## Application Flow

```text
Activity 1 - Registration
        |
        | Enter Name, DOB and Email
        |
   Validate Input
        |
 Store User in Array/List
        |
Activity 2 - User Information
        |
Display All Registered Users
