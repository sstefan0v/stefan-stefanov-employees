(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[995],{2976:function(e,r,l){Promise.resolve().then(l.bind(l,493))},493:function(e,r,l){"use strict";l.r(r);var t=l(7437),s=l(2265);function Grid(){let[e,r]=(0,s.useState)([]);return(0,s.useEffect)(()=>{let e=localStorage.getItem("jsonData");e&&r(JSON.parse(e))},[]),(0,t.jsxs)(t.Fragment,{children:[(0,t.jsx)("div",{className:"flex flex-col items-center",children:(0,t.jsxs)("div",{className:"flex flex-col items-center justify-between",children:[(0,t.jsx)("br",{}),(0,t.jsx)("label",{className:"block mb-2 text-lg font-medium text-blue-900 ",children:"This grid shows the longest days the fowlling employees worked together on a project:"})]})}),(0,t.jsx)("div",{className:"flex items-center justify-center",children:(0,t.jsxs)("div",{className:"grid grid-cols-4 gap-4 p-4 bg-white shadow-lg rounded-lg",children:[(0,t.jsx)("div",{className:"p-4 border rounded-lg text-center bg-blue-300",children:"Employee #1"}),(0,t.jsx)("div",{className:"p-4 border rounded-lg text-center bg-blue-300",children:"Employee #2"}),(0,t.jsx)("div",{className:"p-4 border rounded-lg text-center bg-blue-300",children:"Project ID"}),(0,t.jsx)("div",{className:"p-4 border rounded-lg text-center bg-blue-300",children:"Days worked "}),e.map((e,r)=>(0,t.jsxs)(t.Fragment,{children:[(0,t.jsx)("div",{className:"p-4 border rounded-lg text-center bg-blue-100",children:null==e?void 0:e.emp1Id},r+(null==e?void 0:e.emp1Id)),(0,t.jsx)("div",{className:"p-4 border rounded-lg text-center bg-blue-100",children:null==e?void 0:e.emp2Id},r+(null==e?void 0:e.emp2Id)),(0,t.jsx)("div",{className:"p-4 border rounded-lg text-center bg-blue-100",children:null==e?void 0:e.projectId},r+(null==e?void 0:e.projectId)),(0,t.jsx)("div",{className:"p-4 border rounded-lg text-center bg-blue-100",children:null==e?void 0:e.lengthDays},r+(null==e?void 0:e.lengthDays))]}))]})})]})}let Result=class Result extends s.Component{render(){return(0,t.jsx)("div",{className:"min-h-screen",children:(0,t.jsx)(Grid,{})})}constructor(e){super(e)}};r.default=Result},622:function(e,r,l){"use strict";/**
 * @license React
 * react-jsx-runtime.production.min.js
 *
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */var t=l(2265),s=Symbol.for("react.element"),n=Symbol.for("react.fragment"),d=Object.prototype.hasOwnProperty,o=t.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED.ReactCurrentOwner,c={key:!0,ref:!0,__self:!0,__source:!0};function q(e,r,l){var t,n={},i=null,a=null;for(t in void 0!==l&&(i=""+l),void 0!==r.key&&(i=""+r.key),void 0!==r.ref&&(a=r.ref),r)d.call(r,t)&&!c.hasOwnProperty(t)&&(n[t]=r[t]);if(e&&e.defaultProps)for(t in r=e.defaultProps)void 0===n[t]&&(n[t]=r[t]);return{$$typeof:s,type:e,key:i,ref:a,props:n,_owner:o.current}}r.Fragment=n,r.jsx=q,r.jsxs=q},7437:function(e,r,l){"use strict";e.exports=l(622)}},function(e){e.O(0,[971,472,744],function(){return e(e.s=2976)}),_N_E=e.O()}]);