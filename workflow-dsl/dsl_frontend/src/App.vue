<template>
  <!-- FILE: <project>/frontend/src/App.vue -->
  <div id="app">
    <div class="container">
      <div class="topbar">
        <div class="topbarTitle">
          <span>MDEForgeWL Prototype</span>
        </div>
        <div class="topbarDocs" @click="openDoc">
          <img src="/images/book.png" alt="">
          <hr>
          <p>Documentation</p>
        </div>
      </div>
      <div class="content">
        <div class="contentEditor">
          <div class="editorRun" >
            <!-- <div class="editorRunTitle"> -->
              <p class="execute" @click="compileToJS">Execute</p>
              <img @click="compileToJS" src="images/execute.png" alt="">
            <!-- </div> -->
          </div>
          <div id="xtext-editor" :data-editor-xtext-lang="this.dslFileExtension" class="editorInput">
            /* Please click documentation button to get started */
          </div>
        </div>
        <div class="contentConsole">
          <ConsoleView id="console-view" />
          <!-- <div class="consoleTitle">Console Title</div>
          <div class="consoleDisplay">Display</div> -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import { protocol, baseUrl } from "@/services/ConnectionData.js";
  import ConsoleView from "@/components/ConsoleView";
  import CompilerService from "@/services/CompilerService";

  export default {
    name: "App",
    components: {
      ConsoleView,
    },
    data() {
      return {
        xtextEditor: null,
        scriptContainer: null,
        dslFileExtension: "",
      };
    },
    mounted() {
      /* If the _xtext object is not null when we mount this component, we can continue to configure our editor, otherwise we will wait for the 'ready' event */

      !window._xtext
        ? window.xtextReadyEvent.on("ready", this.setXtextEditor)
        : this.setXtextEditor();
    },
    methods: {
      setXtextEditor() {
        /* The serviceUrl contains the URL, on which
         the language server is reachable */
        this.dslFileExtension = window._dslFileExtension;

        /* We have to wait until rendering of this.dslFileExtension
        in data-editor-xtext-lang attribute finishes
        before we initialize the editor */

        this.$nextTick(() => {
          this.xtextEditor = window._xtext.createEditor({
            baseUrl: "/",
            serviceUrl: `${protocol}${baseUrl}xtext-service`,
            syntaxDefinition: `xtext-resources/generated/mode-${this.dslFileExtension}.js`,
            enableCors: true,
            loadFromServer: false,
            resourceId: "./n.wl",
          });
        });
      },
      openDoc() {
        window.open(
          (window.location.href =
            "https://docs.google.com/document/d/1XrZDK-Z1Q3tmanqjvfaCfil4-XmvH-iRP-G5aLqm5pM/edit?usp=sharing"),
          "_blank"
        );
      },
      async compileToJS() {
        try {
          // Take the editor content and send it to the backend
          const response = await CompilerService.compileCode(
            this.xtextEditor.getValue()
          );
          const compiledCode = response.data.code;
          // Execute the compiled code
          this.runCompiledCode(compiledCode);
        } catch (err) {
          console.error(err.error);
        }
      },
      runCompiledCode(compiledCode) {
        try {
          const headDOM = document.getElementsByTagName("head")[0];
          // Remove prior created script DOM if one exists
          if (this.scriptContainer) headDOM.removeChild(this.scriptContainer);

          // Create a script DOM which will contain the compiled code
          this.scriptContainer = document.createElement("script");
          this.scriptContainer.innerHTML = `
        try {
          async function run() {
              ${compiledCode}
          }
          run()
        } catch (err) {
          console.error('COMPILED CODE ERROR:', err)
        }
        `;
          // Appending the script DOM to the head will lead to autmatic execution
          // of the appended script DOM
          headDOM.appendChild(this.scriptContainer);
        } catch (err) {
          console.error(err);
        }
      },
    },
  };
</script>

<style>
  *{
    box-sizing: border-box;
    margin: 0;
    padding: 0;


  }

  .container {
    width: 100%;
    min-width: 1178px;
    min-height: 363px;
  }

  .topbar{
    width: 100%;
    height: 120px;
    display: flex;
    background-color: #3b3c3d;
    align-items: center;
    position: relative;
  }

  .topbarTitle {

    flex: 3;
    width: 100%;
    height: 70px;
    color:black;
    background-color: yellow;
    text-align: center;
    line-height: 70px;
    margin-right: 300px;
    margin-left: 300px;
    border-radius: 15px;
    -webkit-box-shadow: 2px 2px 10px 9px rgba(0,0,0,0.87); 
    box-shadow: 2px 2px 10px 9px rgba(0,0,0,0.87);


  }



  .topbarDocs{
    flex: 1;
    width: 100%;
    height: 70px;
    margin-right: 100px;

  }

  .topbarDocs img{
    width: 120px;
    height: 60px;
    display: block;
    margin-right: auto;
    margin-left: auto;
    cursor: pointer;
  }

  .topbarDocs p{
    color: white;
    text-align: center;
    cursor: pointer;
  }

  .content {
    width: 100%;
    display: flex;
  }

  .contentEditor{
    flex: 4;
  }

  .editorRun{
    border: 2px solid black;
    align-items: center;
    justify-content: center;
    display: flex;
    margin-left: auto;
    margin-right: auto;

  }

  .editorRun img{
    width: 30px;
    margin: 2px;
    cursor: pointer;
  }

  .editorRun img:active{
        -webkit-box-shadow: 2px 2px 10px 9px rgba(172, 172, 172, 0.87); 
    box-shadow: 2px 2px 10px 9px rgba(131, 131, 131, 0.87);
  }

  .editorRun .execute{
      padding: 4px;
      margin: 2px;
      cursor: pointer;
  
  }

  .editorRun .execute:active{
    -webkit-box-shadow: 2px 2px 10px 9px rgba(0,0,0,0.87); 
    box-shadow: 2px 2px 10px 9px rgba(0,0,0,0.87);
  }

  #xtext-editor {
   height: calc(100vh - 160px);
    width: 100%;
    border: 1px solid #aaa;
  }


  .contentConsole{
    flex: 2
  }



  /* html,
  body,
  #app {
    height: 100%;
    margin: 0;
    padding: 0;
  }

  body {
    align-items: center;
    justify-content: center;
    display: flex;
    width: 100%;
  }

  #app {
    display: flex;
    width: 100%;
    flex-direction: column;
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    height: 90%;
    justify-content: center;
    align-items: center;
  }

  #controls,
  .content {
    width: 90%;
  }

  .content {
    display: flex;
    min-height: 100%;
  }

  #xtext-editor {
    position: relative;
    height: 100%;
    width: 100%;
    border: 1px solid #aaa;
  }

  #console-view {
    position: relative;
    width: 100%;
    height: 100%;
    border: 1px solid #aaa;
  }

  .tatanya {
    display: flex;
    justify-content: space-between;
  } */
</style>
