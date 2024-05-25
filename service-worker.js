/**
 * Welcome to your Workbox-powered service worker!
 *
 * You'll need to register this file in your web app and you should
 * disable HTTP caching for this file too.
 * See https://goo.gl/nhQhGp
 *
 * The rest of the code is auto-generated. Please don't update this file
 * directly; instead, make changes to your Workbox build configuration
 * and re-run your build process.
 * See https://goo.gl/2aRDsh
 */

importScripts("https://storage.googleapis.com/workbox-cdn/releases/4.3.1/workbox-sw.js");

self.addEventListener('message', (event) => {
  if (event.data && event.data.type === 'SKIP_WAITING') {
    self.skipWaiting();
  }
});

/**
 * The workboxSW.precacheAndRoute() method efficiently caches and responds to
 * requests for URLs in the manifest.
 * See https://goo.gl/S9QRab
 */
self.__precacheManifest = [
  {
    "url": "03-01.jpg",
    "revision": "61ccd31b9a99e4dc0b2115d7a181dc71"
  },
  {
    "url": "03-02.jpg",
    "revision": "0e42c83dcc174ebfdbb611ab0956fcd9"
  },
  {
    "url": "03-03.jpg",
    "revision": "dd23072447e0798b536bd162235d14c3"
  },
  {
    "url": "03-04.jpg",
    "revision": "661a64ee2776ef94b23ba82f7ee50969"
  },
  {
    "url": "03-05.jpg",
    "revision": "6f52dcb2ccb40af28a65a4b796eb918d"
  },
  {
    "url": "03-06.jpg",
    "revision": "2643698d9412e41a449c1edee719fb29"
  },
  {
    "url": "03-07.jpg",
    "revision": "c4a788f41d803f8b9bddb5adc0513be6"
  },
  {
    "url": "03-08.jpg",
    "revision": "4c810503ec4bc1adfd29904056fc2886"
  },
  {
    "url": "03-09.jpg",
    "revision": "9c798bc91f80f84b6b0e7f7fba26d65b"
  },
  {
    "url": "03-10.jpg",
    "revision": "bb5b18b65591e9d058edbc14b02c6ba5"
  },
  {
    "url": "03-11.jpg",
    "revision": "6a88d8f48c63e79c72ec45ae84a8d9ff"
  },
  {
    "url": "04-01.jpg",
    "revision": "4bbafd5dd4000461cef55f669139b17b"
  },
  {
    "url": "05-01.jpg",
    "revision": "8d54b111a4b6b5fb4cd39e4c7261b927"
  },
  {
    "url": "06-01.jpg",
    "revision": "cf2dab320c48c5ead6fe105863629e4e"
  },
  {
    "url": "06-02.jpg",
    "revision": "aa286f8fd6540b7a7b6d36392a63f505"
  },
  {
    "url": "06-03.jpg",
    "revision": "239fa5fb2a9063f1e261ae2db81fceef"
  },
  {
    "url": "06-04.jpg",
    "revision": "a2dbf924afd6a8580ce4a2d2bcd6e049"
  },
  {
    "url": "06-05.jpg",
    "revision": "22f4f542b283cdc3d027eb664424d3c8"
  },
  {
    "url": "06-06.jpg",
    "revision": "12017ddd5b9179e8f53e93044acee998"
  },
  {
    "url": "06-07.jpg",
    "revision": "1ded65fc56da9f0008ae4ef2eacc8175"
  },
  {
    "url": "1.jpg",
    "revision": "f1ea37a492254cc85dd6fd1e89b1a6b4"
  },
  {
    "url": "1.png",
    "revision": "d41d8cd98f00b204e9800998ecf8427e"
  },
  {
    "url": "12-01.jpg",
    "revision": "cc85570b3c89f73291af87791115986a"
  },
  {
    "url": "12-02.jpg",
    "revision": "f2b24c5c4beb21d5302c64b59445927a"
  },
  {
    "url": "12-03.jpg",
    "revision": "61fe98dff39d0887978deb0af605571b"
  },
  {
    "url": "12-04.jpg",
    "revision": "ff2468e7fbb03e034be0ffd7312dc7d9"
  },
  {
    "url": "12-05.jpg",
    "revision": "a126fe17514d81279c677666fd459d9d"
  },
  {
    "url": "12-06.jpg",
    "revision": "c25686b2f77ac7c5a2d4706f43e40132"
  },
  {
    "url": "12-07.jpg",
    "revision": "de17f3eb1df503250bcf1a5a4b533eec"
  },
  {
    "url": "12-08.jpg",
    "revision": "f3b58c768c18919a6fa2ab59ea6627db"
  },
  {
    "url": "13-01.jpg",
    "revision": "b22f06060909d43d796a8ffd4b0743a0"
  },
  {
    "url": "13-02.jpg",
    "revision": "2d2bca0518716a8dfaf37ef5c15e54ee"
  },
  {
    "url": "13-03.jpg",
    "revision": "fec1a3db903dc05c462fb6f384a400d6"
  },
  {
    "url": "2.jpg",
    "revision": "572bc2e4ef3efb7c81bbbcac5f09147b"
  },
  {
    "url": "3.jpg",
    "revision": "248757985bb49f73624c6923057530ac"
  },
  {
    "url": "4.jpg",
    "revision": "407c52446e2e463c4f8e494d52dbe485"
  },
  {
    "url": "404.html",
    "revision": "774c6cd35517a7a67e764ba1a8429b28"
  },
  {
    "url": "5.jpg",
    "revision": "7e861769b640afa00fcc0ac4b72d9c52"
  },
  {
    "url": "assets/css/0.styles.4a0bac5e.css",
    "revision": "1e12c16e092843e90c26a1e6bb568e39"
  },
  {
    "url": "assets/img/add-member-request.8c294d5a.jpg",
    "revision": "8c294d5a4ec068575aab0c414795f660"
  },
  {
    "url": "assets/img/add-member-result.c6744fd6.jpg",
    "revision": "c6744fd6dc2987e86576e7fcc1c0c5ac"
  },
  {
    "url": "assets/img/add-task.d5044a52.jpg",
    "revision": "d5044a5216d81bc99fe1f11ea26690e6"
  },
  {
    "url": "assets/img/all-projects.aa7809b2.jpg",
    "revision": "aa7809b2b6746e5a2408eda1ecb7fff8"
  },
  {
    "url": "assets/img/all-roles.d9149337.jpg",
    "revision": "d9149337bf169d9e2430e76a300ec951"
  },
  {
    "url": "assets/img/all-users.63229ef9.jpg",
    "revision": "63229ef9a8a912e1533e1ffe8015df2c"
  },
  {
    "url": "assets/img/create-project.e9981023.jpg",
    "revision": "e99810237e711ebf4f05c1f3b4a642c6"
  },
  {
    "url": "assets/img/create-role.92e8722a.jpg",
    "revision": "92e8722a9f8652171218546922bbbaa8"
  },
  {
    "url": "assets/img/create-user.4ae55881.jpg",
    "revision": "4ae55881cde61d267dd972b3a75b78e4"
  },
  {
    "url": "assets/img/delete-member.18cdeeeb.jpg",
    "revision": "18cdeeeb7b21205de17e23a9fea07664"
  },
  {
    "url": "assets/img/delete-task.594173cf.jpg",
    "revision": "594173cf3c8996348cd945c97a85e3d3"
  },
  {
    "url": "assets/img/project-members.e051dafd.jpg",
    "revision": "e051dafd8abfaadb5156a1e0246d0f80"
  },
  {
    "url": "assets/img/project-tasks.c69b2947.jpg",
    "revision": "c69b2947e7029a095fdca15080524dbc"
  },
  {
    "url": "assets/img/relationalSchema.03c9cba4.png",
    "revision": "03c9cba456d7d301109ba0cfdbecafec"
  },
  {
    "url": "assets/img/search.83621669.svg",
    "revision": "83621669651b9a3d4bf64d1a670ad856"
  },
  {
    "url": "assets/img/user-projects.8796e53e.jpg",
    "revision": "8796e53eb785259f31d86dc820ccbb74"
  },
  {
    "url": "assets/js/10.cee70526.js",
    "revision": "88e98b70020505ab2bbf4085ebcfe247"
  },
  {
    "url": "assets/js/11.ee501e3f.js",
    "revision": "5b5e9f470acf850c2716aecd811ccc3f"
  },
  {
    "url": "assets/js/12.f155a2ce.js",
    "revision": "3fc94067fd4e41348fca3ce9e9ac1eef"
  },
  {
    "url": "assets/js/13.5d263697.js",
    "revision": "83420c58f3b087b5e37c8e3c6c200653"
  },
  {
    "url": "assets/js/14.9e882261.js",
    "revision": "c49a8c6319b7b590beb21a79c4da104f"
  },
  {
    "url": "assets/js/15.f7daef98.js",
    "revision": "136183f7f1664be9a51474de3cf408d9"
  },
  {
    "url": "assets/js/16.da2ec839.js",
    "revision": "d70e25bd2fd772ac5f12b2eee6766cab"
  },
  {
    "url": "assets/js/17.32c4ce1b.js",
    "revision": "a2c5f3362ccd50a9cea274dc0a9b308d"
  },
  {
    "url": "assets/js/18.d17b4c6a.js",
    "revision": "9e1467ef283e7ea65d97a7f6bf50656a"
  },
  {
    "url": "assets/js/19.05202b42.js",
    "revision": "668baea15b68ff7bf6536ad6b62f8789"
  },
  {
    "url": "assets/js/2.1a4a3ae0.js",
    "revision": "6c167b84e5a2cf60395f6fef9bd243eb"
  },
  {
    "url": "assets/js/20.7a9810e0.js",
    "revision": "a61c209906dbebc4dd8406fe7a707aa0"
  },
  {
    "url": "assets/js/21.6c8b45fa.js",
    "revision": "6489c0c9cd4f3dfd28a0ce81fab42daa"
  },
  {
    "url": "assets/js/22.22304807.js",
    "revision": "e3cc65c5396acedc0990a090aab286ae"
  },
  {
    "url": "assets/js/23.bd366bd7.js",
    "revision": "3f08d267709b21699495400304312ca9"
  },
  {
    "url": "assets/js/24.f1f0ab32.js",
    "revision": "f1d439854e026336fe115a876ab1522c"
  },
  {
    "url": "assets/js/26.5bd25fcc.js",
    "revision": "72044f91fb7b60e00c74d35df03ab974"
  },
  {
    "url": "assets/js/3.b2c0d3f3.js",
    "revision": "66cf7e4303d9cc8ddfe57aebfb326137"
  },
  {
    "url": "assets/js/4.0627f762.js",
    "revision": "a00f7f7abedcb50b05e2cfceee4389bf"
  },
  {
    "url": "assets/js/5.33422f11.js",
    "revision": "3426947ec7a7c87f0c83bf15576c769d"
  },
  {
    "url": "assets/js/6.bc2e0d81.js",
    "revision": "9f231985b1e52e7c3ce484f49f85d71c"
  },
  {
    "url": "assets/js/7.0d757912.js",
    "revision": "0a5f71e0cf92f1e640f58e9edbbe7f7e"
  },
  {
    "url": "assets/js/8.0f614ac4.js",
    "revision": "6ec9216ebc11b8b71d8ed2c9cfd84cad"
  },
  {
    "url": "assets/js/9.755af091.js",
    "revision": "0550f7800a94ba5721e3fd6066e8affe"
  },
  {
    "url": "assets/js/app.3cb179fb.js",
    "revision": "2a40320af37d16c48fb5ba53f3d95065"
  },
  {
    "url": "conclusion/index.html",
    "revision": "57c648596f976eb5626a190557b4c212"
  },
  {
    "url": "design/index.html",
    "revision": "fd77c63bb802ce1d249f3e7660cae1f9"
  },
  {
    "url": "index.html",
    "revision": "83eaf246042fec2934bc258ab0d41375"
  },
  {
    "url": "intro/index.html",
    "revision": "e79ce28a8872bc909000a431490e9792"
  },
  {
    "url": "license.html",
    "revision": "c6ae94487788630ac26fdec72cecb7f2"
  },
  {
    "url": "myAvatar.png",
    "revision": "b76db1e62eb8e7fca02a487eb3eac10c"
  },
  {
    "url": "requirements/index.html",
    "revision": "8ce1f195cf7404e4b677023352191f5e"
  },
  {
    "url": "requirements/stakeholders-needs.html",
    "revision": "837384df752edd4767f79c401a75281a"
  },
  {
    "url": "requirements/state-of-the-art.html",
    "revision": "7d036c73fd327350afde1b1faa11d358"
  },
  {
    "url": "software/index.html",
    "revision": "9cb6d3d2edb6524b97cc8b881ce5254b"
  },
  {
    "url": "test/index.html",
    "revision": "a75c9e53f9899a75e031dfdb224d6d06"
  },
  {
    "url": "use cases/index.html",
    "revision": "72af4b4c80c221738654ae21364d0901"
  }
].concat(self.__precacheManifest || []);
workbox.precaching.precacheAndRoute(self.__precacheManifest, {});
addEventListener('message', event => {
  const replyPort = event.ports[0]
  const message = event.data
  if (replyPort && message && message.type === 'skip-waiting') {
    event.waitUntil(
      self.skipWaiting().then(
        () => replyPort.postMessage({ error: null }),
        error => replyPort.postMessage({ error })
      )
    )
  }
})
