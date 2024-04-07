def call(Map config = [:]) {
// send to email
emailext (
  subject: "${config.message}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
  mimetype: 'text/html',
  body: """<p>${config.message}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p><p>Repo: ${config.repo}</p>
           <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
  recipientProviders: [[$class: 'RequesterRecipientProvider']]
  )
}
