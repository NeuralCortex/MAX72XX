#include <LedControl.h>

/*
  Now we need a LedControl to work with.
 ***** These pin numbers will probably not work with your hardware *****
  pin 12 is connected to the DataIn
  pin 11 is connected to LOAD(CS)
  pin 10 is connected to the CLK
  We have only a single MAX72XX.
*/
LedControl lc = LedControl(12, 10, 11, 1);

unsigned long dly = 50;

void setup() {
  Serial.begin(9600);
  lc.shutdown(0, false);
  lc.setIntensity(0, 8);
  lc.clearDisplay(0);
}

void showByteArray(byte arr[]) {
  int cnt = 0;
  for (int i = 0; i < 8; i++) {
    lc.setRow(0, cnt++, arr[i]);
  }
}

void stars() {
  int x = rand() % 8;
  int y = rand() % 8;

  delay(dly);
  lc.setLed(0, x, y, true);
  delay(dly);
  lc.setLed(0, x, y, false);
}

void binaryCount() {
  for (byte i = 0x00; i < 0xFF; i++) {
    for (int j = 0; j < 8; j++) {
      lc.setColumn(0, j, i);
    }
    delay(dly);
  }
}

void loop() {
  byte arr[8] = { 0x21, 0x22, 0x24, 0x28, 0x30, 0x3f, 0x0, 0x0 };
  showByteArray(arr);
  //binaryCount();
  //stars();
}