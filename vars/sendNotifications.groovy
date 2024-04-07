def call(String repo, String message) {
// send to email
emailext (
  subject: "${config.message}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
  body: """<p>${config.message}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p><p>Repo: ${config.repo}</p>
           <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
  recipientProviders: [[$class: 'DevelopersRecipientProvider']]
  )
}
