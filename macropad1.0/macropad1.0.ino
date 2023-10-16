/*  
  Program to make a macropad output different key and button presses to a serial monitor
  Keys go from right to left and top to bottom starting at 0
  output of info is a mess but I may fix
  */
  // keyboard matrix pins
#define Row1 16
#define Row2 15
#define Col1 18
#define Col2 19
#define Col3 20
#define Col4 21
//Define Num Rows and Num Columns
const int Num_Rows = 2;
const int Num_Cols = 4;
// Rotary encoder rotation pins (CLK)
#define Knob_Rotation1 10
#define Knob_Rotation2 7
#define Knob_Rotation3 4
// Define number of Knobs
const int Num_Knobs = 3;
// // Rotary encoder rotation direction pins (DT)
#define Knob_Direction1 9
#define Knob_Direction2 6
#define Knob_Direction3 3
// Rotary encoder button pins (SW)
#define Knob_Button1 8
#define Knob_Button2 5
#define Knob_Button3 2
// LED display pins (WIP)
#define Display_SCL 0
#define Display_SDA 1
const int debounceDelay = 20;  // Debounce delay in milliseconds

bool multiKeyPress[Num_Rows][Num_Cols]; // Matrix to store key values ([number of rows][number of columns])
bool lastKeyPress[Num_Rows][Num_Cols];  // Array to store previous key state
bool lastButtonPress[Num_Knobs]; // Array to store button values
unsigned long lastDebounceTime[Num_Rows][Num_Cols];  // Array to store last debounce time
bool lastStateCLK[Num_Knobs];
int currentStateCLK;
int Num_Rotations[Num_Knobs];

void setup() {
  // put your setup code here, to run once:
  pinMode(Row1, OUTPUT);
  pinMode(Row2, OUTPUT);
  // Set column pins as outputs
  pinMode(Col1, INPUT_PULLUP);
  pinMode(Col2, INPUT_PULLUP);
  pinMode(Col3, INPUT_PULLUP);
  pinMode(Col4, INPUT_PULLUP);
  pinMode(Knob_Button1, INPUT);
  pinMode(Knob_Button2, INPUT);
  pinMode(Knob_Button3, INPUT);
  pinMode(Knob_Direction1, INPUT);
  pinMode(Knob_Direction2, INPUT);
  pinMode(Knob_Direction3, INPUT);
  pinMode(Knob_Rotation1, INPUT);
  pinMode(Knob_Rotation2, INPUT);
  pinMode(Knob_Rotation3, INPUT);
}
void handleKeyPress(int row, int col) {
  // Determine the pressed key based on the row and column
  // Perform the desired action for the key press
  /* Debug code
  for (int rowlist = 0; rowlist < Num_Rows; rowlist++) {
    for (int collist = 0; collist < Num_Cols; collist++) {
      if (multiKeyPress[rowlist][collist]) {
        Serial.println(String("Row ") + rowlist + ", Col " + collist + " is pressed");
      }
      else {
        Serial.println(String("Row ") + rowlist + ", Col " + collist + " is unpressed");
      }
      delay(100); // Add a delay of 100 milliseconds (adjust as needed)
    }
  }
  */
  Serial.println(String("K1") + row + col); //"Key" "Press" "Row" "Col" in one line
}
void handleKeyRelease(int row, int col) {
  // Determine the released key based on the row and column
  // Perform the desired action for the key release
  if (!multiKeyPress[row][col]) {
    /* Debug Code
    Serial.println(String("Row ") + row + ", Col " + col + " is released");
  } else {
    Serial.println(String("Row ") + row + ", Col " + col + " is still pressed");
  }
  */
    Serial.println(String("K0") + row + col); //"Key" "Release" "Row" "Col" in one line
}
}

void handleButtonPress(int button) {
  /* Debug code
  Serial.println(String("Button") + button + " is pressed");
  */
  Serial.println(String("B1") + button + ("0"));// "Button" "Press" "button" "0 for fill"
}
void handleButtonRelease(int button) {
   /* Debug code
  Serial.println(String("Button ") + button + " is released");
  */
  Serial.println(String("B0") + button + ("0")); // "Button" "Release" "button" "0 for fill"
}

void handleRotationCCW(int knob) {
  /* Debug code
  Serial.println(String("Knob ") + knob + " was rotated counter clock wise");
  */
  Serial.println(String("N0")+ knob + ("0")); // "Knob" "0 for ccw" "knob" "0 for fill"
}
void handleRotationCW(int knob) {
  /* Debug code
  Serial.println(String("Knob ") + knob + " was rotated clock wise");
  */
  Serial.println(String("N1")+ knob + ("0")); // // "Knob" "1 for cw" "knob" "0 for fill"
}

int getButtonPin(int button) {
  switch(button) {
    case 0:
      return Knob_Button1;
    case 1:
      return Knob_Button2;
    case 2:
      return Knob_Button3;
    default:
      return -1;
  }
}
int getColumnPin(int col) {
  // Return the pin number based on the column index
  switch (col) {
    case 0:
      return Col1;
    case 1:
      return Col2;
    case 2:
      return Col3;
    case 3:
      return Col4;
    default:
      return -1; // Invalid column index
  }
}
int getRowPin(int row) {
  // Return the pin number based on the row index
  switch (row) {
    case 0:
      return Row1;
    case 1:
      return Row2;
    default:
      return -1; // Invalid row index
  }
}
int getRotationPin(int knob) {
  // Return the CLK pin based on current knob
  switch(knob) {
    case 0:
      return Knob_Rotation1;
    case 1:
      return Knob_Rotation2;
    case 2:
      return Knob_Rotation3;
    default:
      return -1;
  }
}
int getDirectionPin(int knob) {
  // Return the DT pin based on current knob
  switch(knob) {
    case 0:
      return Knob_Direction1;
    case 1:
      return Knob_Direction2;
    case 2:
      return Knob_Direction3;
    default:
      return -1;
  }
}

void loop() {
  // Handle Keyboard matrix and keypresses
  for (int row = 0; row < Num_Rows; row++) {
    digitalWrite(getRowPin(row), LOW);

    for (int col = 0; col < Num_Cols; col++) {
      bool KeyisPressed = (digitalRead(getColumnPin(col)) == LOW);

      if (KeyisPressed != lastKeyPress[row][col]) {
        lastDebounceTime[row][col] = millis();  // Update last debounce time
      }

      if (millis() - lastDebounceTime[row][col] >= debounceDelay) {
        if (KeyisPressed != multiKeyPress[row][col]) {
          multiKeyPress[row][col] = KeyisPressed;  // Update key state after debounce

          if (KeyisPressed) {
            handleKeyPress(row, col);
          }
          else {
            handleKeyRelease(row, col);
          }
        }
      }

      lastKeyPress[row][col] = KeyisPressed;
    }

    digitalWrite(getRowPin(row), HIGH);
    
  }

  // Handle Rotary encoder button presses
  for (int button = 0; button < Num_Knobs; button++) {
    bool ButtonisPressed = (digitalRead(getButtonPin(button)) == HIGH);
    if (ButtonisPressed == false && lastButtonPress[button] == true) {
      handleButtonPress(button);
    }   
    if (ButtonisPressed == true && lastButtonPress[button] == false) {
      handleButtonRelease(button);
    }
  lastButtonPress[button] = ButtonisPressed;
  }

  // Handle Rotary encoder rotations
  // Problem sometimes if turned rapidly will throw out wrong variable but will work for now
  for (int knob = 0; knob < Num_Knobs; knob++) {
    currentStateCLK = (digitalRead(getRotationPin(knob)));
    if (currentStateCLK != lastStateCLK[knob] && currentStateCLK == 1) {
      if (digitalRead(getDirectionPin(knob)) != currentStateCLK) {
        handleRotationCW(knob);
      }
      else {
        handleRotationCCW(knob);
      }
    }
    lastStateCLK[knob] = currentStateCLK;
  }
}