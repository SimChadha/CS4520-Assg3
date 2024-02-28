Github repo: https://github.com/SimChadha/CS4520-Assg3

Run project:
To run this project, open the project in Android studio and select an emulator to run the app on.
Before running the app, make sure you have run the proper gradle tasks when the IDE prompts at the top.
From there, run the app from Android studio using the default configuration to start to app.
The default configuration will run on the module com.cs4520.assignment3 and will launch the
default activity (or com.cs4520.assignment3.MainActivity if you'd prefer to specify).

Project Overview:
This project implements a simple 4 function calculator using a MVP and MVVM architecture.
The MVP uses a View (MVPFragment) and a Model to display and store data respectively while
the Presenter has a direct reference to both the view and model. The presenter has methods
that are called for each button in the calculator's view, and the presenter then processes
the data and sends it to the model for business logic, Finally, the Presenter sends the updated
data to the view to display to the user.

On the other hand, the MVVC architecture works with data differently. The main difference is
that instead of a Presenter, we use a ViewController to facilitate View and Model interactions.
The ViewModel contains two LiveData properties, the result and an errorToast boolean. The view
attaches a listener to the live data from the ViewController and responsively changes its UI
whenever it detects a change in these fields.

Both approaches use the same Model implementation.