grammar Double;

double: '-' getal | getal | getal E ('-')? CIJFER+ | ('-')? getal (E)? ('-')? CIJFER+;

getal: CIJFER+ | kommagetal;
kommagetal: CIJFER+ '.' CIJFER+;
CIJFER: [0-9];
E: 'E' | 'e';
