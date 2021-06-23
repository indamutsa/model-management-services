<template>
  <!-- FILE: <project>/frontend/src/components/ConsoleView.vue -->
  <div class="console">
    <div class="console_header">
      <div class="console_settings">
        <i class="fa fa-trash" title="Clear console" @click="messages = []" />
        <div class="autoscroll" title="Always scroll to last console output">
          <small>Autoscroll:</small>
          <input type="checkbox" v-model="autoscroll" />
        </div>
      </div>
      <div class="console_header_filler">
        <small class="console_title">Console</small>
      </div>
    </div>
    <pre id="console-output">
        <!-- eslint-disable-next-line -->
        <code v-for="msg in messages"><span class="timestamp">[{{msg.time}}]:&nbsp;</span>{{ msg.message }}<br></code>
    </pre>
  </div>
</template>

<script>
  import axios from "axios";
  axios.defaults.headers.common["Access-Control-Allow-Origin"] = "*";

  export default {
    name: "ConsoleView",
    data() {
      return {
        autoscroll: true,
        consoleOutputDOM: null,
        messages: [],
      };
    },
    mounted() {
      this.consoleOutputDOM = document.getElementById("console-output");
      window.printConsoleOutput = this.printConsoleOutput;
      window._transfoModel = this._transfoModel;
      window._validateModel = this._validateModel;
      window._compareModel = this._compareModel;
      window._queryModel = this._queryModel;

      // window._transfoModel = () => {
      //   this.printConsoleOutput("Executing: \nTransforming the model...!");
      // };
    },
    methods: {
      printConsoleOutput(msg) {
        const d = new Date();
        const sec = d.getSeconds() <= 9 ? "0" + d.getSeconds() : d.getSeconds();
        const mins =
          d.getMinutes() <= 9 ? "0" + d.getMinutes() : d.getMinutes();
        const hours = d.getHours() <= 9 ? "0" + d.getHours() : d.getHours();
        const month =
          d.getMonth() + 1 <= 9 ? "0" + (d.getMonth() + 1) : d.getMonth() + 1;
        const date = d.getDate() <= 9 ? "0" + d.getDate() : d.getDate();
        const year = d.getYear() + 1900;
        this.messages.push({
          time: `${month}/${date}/${year} ${hours}-${mins}-${sec}`,
          message: msg,
        });
        if (this.autoscroll) {
          // Prevent blocking and wait for the message to render
          setTimeout(() => {
            this.scrollToBottom();
          }, 1);
        }
      },
      async _transfoModel(sourceM, sourceMM, targetMM, script) {
        // call service _transfoModel("Tree.xmi", "Tree.ecore", "Tree.ecore", "Demo.etl")
        const data = {
          sourceModel: sourceM, //"Tree.xmi",
          sourceMetaModel: sourceMM, //"Tree.ecore",
          targetMetaModel: targetMM, //"Tree.ecore",
          scriptEtl: script, //"Demo.etl",
        };

        console.log(data);

        try {
          await axios
            .post(
              `http://34.89.156.195:30100/api/exec/transform`,
              {
                sourceModel: sourceM,
                sourceMetaModel: sourceMM,
                targetMetaModel: targetMM,
                scriptEtl: script,
              },
              {
                headers: {
                  // remove headers
                },
              }
            )
            .then((response) => {
              printConsoleOutput(
                `\nExecuting: \nTransforming the model...!\n\nCode: ${response.status} -- sucesss` +
                  "\n---------------------\n" +
                  response.data.message +
                  "--------------------------"
              );
            })
            .catch((err) => {
              printConsoleOutput(
                "\nExecuting: \nTransforming the model...!\n" +
                  "\n---------------------\n" +
                  `${err}\n` +
                  "Please check your function arguments\n" +
                  "--------------------------"
              );
            });
        } catch (e) {
          console.log(e + "--");
        }
      },
      async _validateModel(m, metaM, script) {
        // call service _validateModel("Tree.xmi", "Tree.ecore", "Demo.evl")
        try {
          await axios
            .post(
              `http://34.89.156.195:30100/api/exec/validate`,
              {
                model: m,
                metaModel: metaM,
                scriptEvl: script,
              },
              {
                headers: {
                  // remove headers
                },
              }
            )
            .then((response) => {
              printConsoleOutput(
                `\nExecuting: \nValidating the model...!\n\nCode: ${response.status} -- sucesss` +
                  "\n---------------------\n" +
                  response.data.message +
                  "--------------------------"
              );
            })
            .catch((err) => {
              printConsoleOutput(
                "\nExecuting: \nValidating the model...!\n" +
                  "\n---------------------\n" +
                  `${err}\n` +
                  "Please check your function arguments\n" +
                  "--------------------------"
              );
            });
        } catch (e) {
          console.log(e + "--");
        }
      },
      async _compareModel(m1, m2, script) {
        // call service _compareModel("catalogue1.xml", "catalogue2.xml", "Demo.ecl")
        try {
          await axios
            .post(
              `http://34.89.156.195:30100/api/exec/compare`,
              {
                model1: "catalogue1.xml",
                model2: "catalogue2.xml",
                scriptEcl: "Demo.ecl",
              },
              {
                headers: {
                  // remove headers
                },
              }
            )
            .then((response) => {
              printConsoleOutput(
                `\nExecuting: \nComparing the models...!\n\nCode: ${response.status} -- sucesss` +
                  "\n---------------------\n" +
                  response.data.message +
                  "\n--------------------------"
              );
            })
            .catch((err) => {
              printConsoleOutput(
                "\nExecuting: \nComparing the models...!\n" +
                  "\n---------------------\n" +
                  `${err}\n` +
                  "Please check your function arguments\n" +
                  "--------------------------"
              );
            });
        } catch (e) {
          console.log(e + "--");
        }
      },
      async _queryModel(m1, metaM, script) {
        // call service _queryModel("Tree.xmi", "Tree.ecore", "Demo.eol")
        try {
          await axios
            .post(
              `http://34.89.156.195:30100/api/exec/query`,
              {
                model: m1,
                metaModel: metaM,
                scriptEol: script,
              },
              {
                headers: {
                  // remove headers
                },
              }
            )
            .then((response) => {
              printConsoleOutput(
                `\nExecuting: \nQuerying the model...!\n\nCode: ${response.status} -- sucesss` +
                  "\n---------------------\n" +
                  response.data.message +
                  "--------------------------"
              );
            })
            .catch((err) => {
              printConsoleOutput(
                "\nExecuting: \nQuerying the model...!\n" +
                  "\n---------------------\n" +
                  `${err}\n` +
                  "Please check your function arguments\n" +
                  "--------------------------"
              );
            });
        } catch (e) {
          console.log(e + "--");
        }
      },
      scrollToBottom() {
        try {
          this.consoleOutputDOM.lastElementChild.scrollIntoView();
        } catch (err) {
          console.log("ConsoleView - scrollToBottom: " + err);
        }
      },
    },
  };
</script>

<style>
  @import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css");

  :root {
    --light-grey: #e0e0e0;
    --grey: #a0a0a0;
  }

  i {
    cursor: pointer;
    height: 1em;
    width: 1em;
  }

  #console-output {
    flex-grow: 1;
    padding-left: 0.5em;
  }

  #console-output code {
    white-space: pre-wrap;
    overflow: auto;
  }

  .autoscroll {
    display: flex;
    flex-direction: row;
    align-items: center;
  }

  .timestamp {
    font-weight: bold;
    color: var(--grey);
  }

  pre {
    white-space: pre-line;
    margin: 0;
    margin-top: -1em;
  }

  .console_settings {
    flex-grow: 1;
    flex-wrap: nowrap;
    flex-direction: row;
    display: flex;
    align-items: center;
  }

  .console_settings small {
    padding-top: 3px;
  }

  .console_settings > * {
    margin-left: 0.5em;
  }

  .console_header {
    padding-left: 0.5em;
    position: sticky;
    top: 0;
    left: 0;
    right: 0;
    height: 1.3em;
    display: flex;
    flex-direction: row;
    align-items: center;
    background-color: var(--light-grey);
    line-height: 1em;
  }

  .console_title {
    padding-top: 3px;
    color: var(--grey);
  }

  .console_header_filler {
    display: flex;
    flex-grow: 1;
    padding-right: 3em;
    justify-content: flex-end;
    flex-direction: row;
  }

  .console {
    display: flex;
    flex-direction: column;
    overflow-y: scroll;
  }
</style>
