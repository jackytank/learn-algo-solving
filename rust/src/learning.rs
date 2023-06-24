use std::env::{Args, args};
use std::io;

pub fn cli_calculator() {
    let mut args: Args = args();
}

pub fn guess_the_number() {
    println!("Guess the number!");
    println!("Please input your guess!");
    let mut guess = String::new();
    io::stdin()
        .read_line(&mut guess)
        .expect("Failed to read line");
    println!("You guessed: {guess}")
}