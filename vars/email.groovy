#!/usr/bin/env groovy

def call(String recipient) {

				emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'sample-email'
       
}
