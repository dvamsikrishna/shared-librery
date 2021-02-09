#!/usr/bin/env groovy

def call(String name = 'nodejs') {
				echo 'npm install'
				bat 'npm install' 
}
