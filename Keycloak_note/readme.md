L0GdQIQazPGBgLMBY3EGyy10s64cPWth



# 키클록 rest Api 정리
 > https://www.keycloak.org/docs-api/22.0.1/javadocs/org/keycloak/admin/client/resource/UsersResource.html
## Update the user
> ### `PUT`  /admin/realms/{realm}/users/{user-id}


 ## Delete the user  
> realm name (not id!)
> ### `DELETE` /admin/realms/{realm}/users/{user-id}




 ## Create a new user Username must be unique.
> ### `POST` /admin/realms/{realm}/users
> Path Parameters : realm
> Body Parameter : UserRepresentation
> Responses : 200 / OK



----------

# 이하 퍼옴 정리 해야됨


-----------
<div class="sect2 Users">
<h3 id="_users">Users</h3>
<div class="sect3 adminRealmsRealmUsersCountGet">
<h4 id="_get_adminrealmsrealmuserscount">GET /admin/realms/{realm}/users/count</h4>
<div class="paragraph">
<p>Returns the number of users that match the given criteria.</p>
</div>
<div class="sect4">
<h5 id="_description_17">Description</h5>
<div class="paragraph">
<p>It can be called in three different ways. 1. Don’t specify any criteria and pass {@code null}. The number of all users within that realm will be returned. &lt;p&gt; 2. If {@code search} is specified other criteria such as {@code last} will be ignored even though you set them. The {@code search} string will be matched against the first and last name, the username and the email of a user. &lt;p&gt; 3. If {@code search} is unspecified but any of {@code last}, {@code first}, {@code email} or {@code username} those criteria are matched against their respective fields on a user entity. Combined with a logical and.</p>
</div>
</div>
<div class="sect4">
<h5 id="_parameters_316">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_314">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_query_parameters_57">Query Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>email</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">email filter</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>emailVerified</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean representing if user is enabled or not</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>firstName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">first name filter</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>lastName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">last name filter</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>q</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>search</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">arbitrary search string for all the fields below. Default search behavior is prefix-based (e.g., foo or foo*). Use <strong>foo</strong> for infix search and &amp;quot;foo&amp;quot; for exact search.</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>username</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">username filter</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_182">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_316">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#Integer">[Integer]</a></p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersGet">
<h4 id="_get_adminrealmsrealmusers">GET /admin/realms/{realm}/users</h4>
<div class="paragraph">
<p>Get users Returns a stream of users, filtered according to query parameters.</p>
</div>
<div class="sect4">
<h5 id="_parameters_317">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_315">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_query_parameters_58">Query Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>briefRepresentation</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean which defines whether brief representations are returned (default: false)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>email</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">A String contained in email, or the complete email, if param &amp;quot;exact&amp;quot; is true</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>emailVerified</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">whether the email has been verified</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean representing if user is enabled or not</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>exact</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean which defines whether the params &amp;quot;last&amp;quot;, &amp;quot;first&amp;quot;, &amp;quot;email&amp;quot; and &amp;quot;username&amp;quot; must match exactly</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>first</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Pagination offset</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>firstName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">A String contained in firstName, or the complete firstName, if param &amp;quot;exact&amp;quot; is true</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>idpAlias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">The alias of an Identity Provider linked to the user</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>idpUserId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">The userId at an Identity Provider linked to the user</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>lastName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">A String contained in lastName, or the complete lastName, if param &amp;quot;exact&amp;quot; is true</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>max</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Maximum results size (defaults to 100)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>q</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">A query to search for custom attributes, in the format &#39;key1:value2 key2:value2&#39;</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>search</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">A String contained in username, first or last name, or email. Default search behavior is prefix-based (e.g., foo or foo*). Use <strong>foo</strong> for infix search and &amp;quot;foo&amp;quot; for exact search.</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>username</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">A String contained in username, or the complete username, if param &amp;quot;exact&amp;quot; is true</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_183">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_317">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List[<a href="#UserRepresentation">UserRepresentation</a>]</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersPost">
<h4 id="_post_adminrealmsrealmusers">POST /admin/realms/{realm}/users</h4>
<div class="paragraph">
<p>Create a new user Username must be unique.</p>
</div>
<div class="sect4">
<h5 id="_parameters_318">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_316">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_body_parameter_100">Body Parameter</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>UserRepresentation</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#UserRepresentation">UserRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_318">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersProfileGet">
<h4 id="_get_adminrealmsrealmusersprofile">GET /admin/realms/{realm}/users/profile</h4>
<div class="sect4">
<h5 id="_description_18">Description</h5>
<div class="paragraph">
<p>Get the configuration for the user profile</p>
</div>
</div>
<div class="sect4">
<h5 id="_parameters_319">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_317">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_184">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_319">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#UPConfig">UPConfig</a></p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersProfileMetadataGet">
<h4 id="_get_adminrealmsrealmusersprofilemetadata">GET /admin/realms/{realm}/users/profile/metadata</h4>
<div class="sect4">
<h5 id="_description_19">Description</h5>
<div class="paragraph">
<p>Get the UserProfileMetadata from the configuration</p>
</div>
</div>
<div class="sect4">
<h5 id="_parameters_320">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_318">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_185">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_320">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#UserProfileMetadata">UserProfileMetadata</a></p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersProfilePut">
<h4 id="_put_adminrealmsrealmusersprofile">PUT /admin/realms/{realm}/users/profile</h4>
<div class="sect4">
<h5 id="_description_20">Description</h5>
<div class="paragraph">
<p>Set the configuration for the user profile</p>
</div>
</div>
<div class="sect4">
<h5 id="_parameters_321">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_319">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_body_parameter_101">Body Parameter</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>UPConfig</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#UPConfig">UPConfig</a></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_186">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_321">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#UPConfig">UPConfig</a></p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdConfiguredUserStorageCredentialTypesGet">
<h4 id="_get_adminrealmsrealmusersuser_idconfigured_user_storage_credential_types">GET /admin/realms/{realm}/users/{user-id}/configured-user-storage-credential-types</h4>
<div class="paragraph">
<p>Return credential types, which are provided by the user storage where user is stored.</p>
</div>
<div class="sect4">
<h5 id="_description_21">Description</h5>
<div class="paragraph">
<p>Returned values can contain for example \"password\", \"otp\" etc. This will always return empty list for \"local\" users, which are not backed by any user storage</p>
</div>
</div>
<div class="sect4">
<h5 id="_parameters_322">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_320">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_187">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_322">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List[<a href="#string">[string]</a>]</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdConsentsClientDelete">
<h4 id="_delete_adminrealmsrealmusersuser_idconsentsclient">DELETE /admin/realms/{realm}/users/{user-id}/consents/{client}</h4>
<div class="paragraph">
<p>Revoke consent and offline tokens for particular client from user</p>
</div>
<div class="sect4">
<h5 id="_parameters_323">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_321">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>client</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Client id</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_323">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdConsentsGet">
<h4 id="_get_adminrealmsrealmusersuser_idconsents">GET /admin/realms/{realm}/users/{user-id}/consents</h4>
<div class="paragraph">
<p>Get consents granted by the user</p>
</div>
<div class="sect4">
<h5 id="_parameters_324">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_322">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_188">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_324">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List[<a href="#AnyType">[AnyType]</a>]</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdCredentialsCredentialIdDelete">
<h4 id="_delete_adminrealmsrealmusersuser_idcredentialscredentialid">DELETE /admin/realms/{realm}/users/{user-id}/credentials/{credentialId}</h4>
<div class="paragraph">
<p>Remove a credential for a user</p>
</div>
<div class="sect4">
<h5 id="_parameters_325">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_323">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>credentialId</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_325">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdCredentialsCredentialIdMoveAfterNewPreviousCredentialIdPost">
<h4 id="_post_adminrealmsrealmusersuser_idcredentialscredentialidmoveafternewpreviouscredentialid">POST /admin/realms/{realm}/users/{user-id}/credentials/{credentialId}/moveAfter/{newPreviousCredentialId}</h4>
<div class="paragraph">
<p>Move a credential to a position behind another credential</p>
</div>
<div class="sect4">
<h5 id="_parameters_326">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_324">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>credentialId</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">The credential to move</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>newPreviousCredentialId</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">The credential that will be the previous element in the list. If set to null, the moved credential will be the first element in the list.</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_326">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdCredentialsCredentialIdMoveToFirstPost">
<h4 id="_post_adminrealmsrealmusersuser_idcredentialscredentialidmovetofirst">POST /admin/realms/{realm}/users/{user-id}/credentials/{credentialId}/moveToFirst</h4>
<div class="paragraph">
<p>Move a credential to a first position in the credentials list of the user</p>
</div>
<div class="sect4">
<h5 id="_parameters_327">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_325">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>credentialId</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">The credential to move</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_327">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdCredentialsCredentialIdUserLabelPut">
<h4 id="_put_adminrealmsrealmusersuser_idcredentialscredentialiduserlabel">PUT /admin/realms/{realm}/users/{user-id}/credentials/{credentialId}/userLabel</h4>
<div class="paragraph">
<p>Update a credential label for a user</p>
</div>
<div class="sect4">
<h5 id="_parameters_328">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_326">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>credentialId</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_body_parameter_102">Body Parameter</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>body</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_328">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdCredentialsGet">
<h4 id="_get_adminrealmsrealmusersuser_idcredentials">GET /admin/realms/{realm}/users/{user-id}/credentials</h4>
<div class="sect4">
<h5 id="_parameters_329">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_327">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_189">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_329">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List[<a href="#CredentialRepresentation">CredentialRepresentation</a>]</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdDelete">
<h4 id="_delete_adminrealmsrealmusersuser_id">DELETE /admin/realms/{realm}/users/{user-id}</h4>
<div class="paragraph">
<p>Delete the user</p>
</div>
<div class="sect4">
<h5 id="_parameters_330">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_328">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_330">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdDisableCredentialTypesPut">
<h4 id="_put_adminrealmsrealmusersuser_iddisable_credential_types">PUT /admin/realms/{realm}/users/{user-id}/disable-credential-types</h4>
<div class="paragraph">
<p>Disable all credentials for a user of a specific type</p>
</div>
<div class="sect4">
<h5 id="_parameters_331">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_329">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_body_parameter_103">Body Parameter</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>string</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_331">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdExecuteActionsEmailPut">
<h4 id="_put_adminrealmsrealmusersuser_idexecute_actions_email">PUT /admin/realms/{realm}/users/{user-id}/execute-actions-email</h4>
<div class="paragraph">
<p>Send an email to the user with a link they can click to execute particular actions.</p>
</div>
<div class="sect4">
<h5 id="_description_22">Description</h5>
<div class="paragraph">
<p>An email contains a link the user can click to perform a set of required actions. The redirectUri and clientId parameters are optional. If no redirect is given, then there will be no link back to click after actions have completed. Redirect uri must be a valid uri for the particular clientId.</p>
</div>
</div>
<div class="sect4">
<h5 id="_parameters_332">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_330">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_body_parameter_104">Body Parameter</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>string</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_query_parameters_59">Query Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>client_id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Client id</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>lifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Number of seconds after which the generated token expires</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>redirect_uri</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Redirect uri</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_332">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdFederatedIdentityGet">
<h4 id="_get_adminrealmsrealmusersuser_idfederated_identity">GET /admin/realms/{realm}/users/{user-id}/federated-identity</h4>
<div class="paragraph">
<p>Get social logins associated with the user</p>
</div>
<div class="sect4">
<h5 id="_parameters_333">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_331">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_190">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_333">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List[<a href="#FederatedIdentityRepresentation">FederatedIdentityRepresentation</a>]</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdFederatedIdentityProviderDelete">
<h4 id="_delete_adminrealmsrealmusersuser_idfederated_identityprovider">DELETE /admin/realms/{realm}/users/{user-id}/federated-identity/{provider}</h4>
<div class="paragraph">
<p>Remove a social login provider from user</p>
</div>
<div class="sect4">
<h5 id="_parameters_334">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_332">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>provider</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Social login provider id</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_334">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdFederatedIdentityProviderPost">
<h4 id="_post_adminrealmsrealmusersuser_idfederated_identityprovider">POST /admin/realms/{realm}/users/{user-id}/federated-identity/{provider}</h4>
<div class="paragraph">
<p>Add a social login provider to the user</p>
</div>
<div class="sect4">
<h5 id="_parameters_335">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_333">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>provider</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Social login provider id</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_335">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdGet">
<h4 id="_get_adminrealmsrealmusersuser_id">GET /admin/realms/{realm}/users/{user-id}</h4>
<div class="paragraph">
<p>Get representation of the user</p>
</div>
<div class="sect4">
<h5 id="_parameters_336">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_334">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_query_parameters_60">Query Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userProfileMetadata</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Indicates if the user profile metadata should be added to the response</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_191">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_336">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#UserRepresentation">UserRepresentation</a></p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdGroupsCountGet">
<h4 id="_get_adminrealmsrealmusersuser_idgroupscount">GET /admin/realms/{realm}/users/{user-id}/groups/count</h4>
<div class="sect4">
<h5 id="_parameters_337">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_335">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_query_parameters_61">Query Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>search</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_192">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_337">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map[<a href="#long">[long]</a>]</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdGroupsGet">
<h4 id="_get_adminrealmsrealmusersuser_idgroups">GET /admin/realms/{realm}/users/{user-id}/groups</h4>
<div class="sect4">
<h5 id="_parameters_338">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_336">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_query_parameters_62">Query Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>briefRepresentation</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">true</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>first</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>max</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>search</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_193">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_338">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List[<a href="#GroupRepresentation">GroupRepresentation</a>]</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdGroupsGroupIdDelete">
<h4 id="_delete_adminrealmsrealmusersuser_idgroupsgroupid">DELETE /admin/realms/{realm}/users/{user-id}/groups/{groupId}</h4>
<div class="sect4">
<h5 id="_parameters_339">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_337">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>groupId</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_339">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdGroupsGroupIdPut">
<h4 id="_put_adminrealmsrealmusersuser_idgroupsgroupid">PUT /admin/realms/{realm}/users/{user-id}/groups/{groupId}</h4>
<div class="sect4">
<h5 id="_parameters_340">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_338">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>groupId</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_340">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdImpersonationPost">
<h4 id="_post_adminrealmsrealmusersuser_idimpersonation">POST /admin/realms/{realm}/users/{user-id}/impersonation</h4>
<div class="paragraph">
<p>Impersonate the user</p>
</div>
<div class="sect4">
<h5 id="_parameters_341">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_339">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_194">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_341">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map[&lt;&lt;&gt;&gt;]</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdLogoutPost">
<h4 id="_post_adminrealmsrealmusersuser_idlogout">POST /admin/realms/{realm}/users/{user-id}/logout</h4>
<div class="paragraph">
<p>Remove all user sessions associated with the user Also send notification to all clients that have an admin URL to invalidate the sessions for the particular user.</p>
</div>
<div class="sect4">
<h5 id="_parameters_342">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_340">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_342">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdOfflineSessionsClientUuidGet">
<h4 id="_get_adminrealmsrealmusersuser_idoffline_sessionsclientuuid">GET /admin/realms/{realm}/users/{user-id}/offline-sessions/{clientUuid}</h4>
<div class="paragraph">
<p>Get offline sessions associated with the user and client</p>
</div>
<div class="sect4">
<h5 id="_parameters_343">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_341">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientUuid</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_195">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_343">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List[<a href="#UserSessionRepresentation">UserSessionRepresentation</a>]</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdPut">
<h4 id="_put_adminrealmsrealmusersuser_id">PUT /admin/realms/{realm}/users/{user-id}</h4>
<div class="paragraph">
<p>Update the user</p>
</div>
<div class="sect4">
<h5 id="_parameters_344">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_342">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_body_parameter_105">Body Parameter</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>UserRepresentation</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#UserRepresentation">UserRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_344">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdResetPasswordEmailPut">
<h4 id="_put_adminrealmsrealmusersuser_idreset_password_email">PUT /admin/realms/{realm}/users/{user-id}/reset-password-email</h4>
<div class="paragraph">
<p>Send an email to the user with a link they can click to reset their password.</p>
</div>
<div class="sect4">
<h5 id="_description_23">Description</h5>
<div class="paragraph">
<p>The redirectUri and clientId parameters are optional. The default for the redirect is the account client. This endpoint has been deprecated.  Please use the execute-actions-email passing a list with UPDATE_PASSWORD within it.</p>
</div>
</div>
<div class="sect4">
<h5 id="_parameters_345">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_343">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_query_parameters_63">Query Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>client_id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">client id</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>redirect_uri</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">redirect uri</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_345">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdResetPasswordPut">
<h4 id="_put_adminrealmsrealmusersuser_idreset_password">PUT /admin/realms/{realm}/users/{user-id}/reset-password</h4>
<div class="paragraph">
<p>Set up a new password for the user.</p>
</div>
<div class="sect4">
<h5 id="_parameters_346">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_344">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_body_parameter_106">Body Parameter</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>CredentialRepresentation</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><a href="#CredentialRepresentation">CredentialRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_346">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">204</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">No Content</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdSendVerifyEmailPut">
<h4 id="_put_adminrealmsrealmusersuser_idsend_verify_email">PUT /admin/realms/{realm}/users/{user-id}/send-verify-email</h4>
<div class="paragraph">
<p>Send an email-verification email to the user An email contains a link the user can click to verify their email address.</p>
</div>
<div class="sect4">
<h5 id="_description_24">Description</h5>
<div class="paragraph">
<p>The redirectUri, clientId and lifespan parameters are optional. The default for the redirect is the account client. The default for the lifespan is 12 hours</p>
</div>
</div>
<div class="sect4">
<h5 id="_parameters_347">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_345">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect5">
<h6 id="_query_parameters_64">Query Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>client_id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Client id</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>lifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Number of seconds after which the generated token expires</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>redirect_uri</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Redirect uri</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_responses_347">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">&lt;&lt;&gt;&gt;</p></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect3 adminRealmsRealmUsersUserIdSessionsGet">
<h4 id="_get_adminrealmsrealmusersuser_idsessions">GET /admin/realms/{realm}/users/{user-id}/sessions</h4>
<div class="paragraph">
<p>Get sessions associated with the user</p>
</div>
<div class="sect4">
<h5 id="_parameters_348">Parameters</h5>
<div class="sect5">
<h6 id="_path_parameters_346">Path Parameters</h6>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 28.5714%;">
<col style="width: 42.8571%;">
<col style="width: 14.2857%;">
<col style="width: 14.2858%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Description</th>
<th class="tableblock halign-left valign-top">Default</th>
<th class="tableblock halign-left valign-top">Pattern</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">realm name (not id!)</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-id</strong><br>
<em>required</em></p></td>
<td class="tableblock halign-left valign-top"></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">null</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect4">
<h5 id="_content_type_196">Content Type</h5>
<div class="ulist">
<ul>
<li>
<p><code>application/json</code></p>
</li>
</ul>
</div>
</div>
<div class="sect4">
<h5 id="_responses_348">Responses</h5>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 50%;">
<col style="width: 16.6667%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Code</th>
<th class="tableblock halign-left valign-top">Message</th>
<th class="tableblock halign-left valign-top">Datatype</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">200</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">OK</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List[<a href="#UserSessionRepresentation">UserSessionRepresentation</a>]</p></td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="models">Definitions</h2>
<div class="sectionbody">
<div class="sect2">
<h3 id="AbstractPolicyRepresentation">AbstractPolicyRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-AbstractPolicyRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>type</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>policies</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resources</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>logic</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Logic</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>decisionStrategy</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">DecisionStrategy</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>owner</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resourcesData</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#ResourceRepresentation">ResourceRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopesData</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#ScopeRepresentation">ScopeRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="Access">Access</h3>
<table class="tableblock frame-all grid-all stretch fields-Access">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>roles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>verify_caller</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="AccessToken">AccessToken</h3>
<table class="tableblock frame-all grid-all stretch fields-AccessToken">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>jti</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>exp</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>nbf</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>iat</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>iss</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>sub</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>typ</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>azp</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>otherClaims</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#AnyType">[AnyType]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>nonce</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>auth_time</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>session_state</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>at_hash</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>c_hash</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>given_name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>family_name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>middle_name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>nickname</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>preferred_username</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>profile</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>picture</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>website</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>email</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>email_verified</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>gender</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>birthdate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>zoneinfo</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>locale</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>phone_number</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>phone_number_verified</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>address</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">AddressClaimSet</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>updated_at</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>claims_locales</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>acr</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>s_hash</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authTime</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>sid</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>trusted-certs</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>allowed-origins</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm_access</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Access</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resource_access</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#Access">Access</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authorization</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Authorization</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>cnf</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Confirmation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scope</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="AddressClaimSet">AddressClaimSet</h3>
<table class="tableblock frame-all grid-all stretch fields-AddressClaimSet">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>formatted</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>street_address</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>locality</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>region</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>postal_code</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>country</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="AdminEventRepresentation">AdminEventRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-AdminEventRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>time</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realmId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authDetails</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">AuthDetailsRepresentation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>operationType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resourceType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resourcePath</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>representation</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>error</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ApplicationRepresentation">ApplicationRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ApplicationRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>rootUrl</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>adminUrl</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>baseUrl</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>surrogateAuthRequired</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>alwaysDisplayInConsole</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientAuthenticatorType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>secret</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>registrationAccessToken</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultRoles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>redirectUris</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webOrigins</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>notBefore</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>bearerOnly</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>consentRequired</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>standardFlowEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>implicitFlowEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>directAccessGrantsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>serviceAccountsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authorizationServicesEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>directGrantsOnly</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>publicClient</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>frontchannelLogout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocol</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticationFlowBindingOverrides</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>fullScopeAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>nodeReRegistrationTimeout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>registeredNodes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#integer">[integer]</a></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocolMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ProtocolMapperRepresentation">ProtocolMapperRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientTemplate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>useTemplateConfig</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>useTemplateScope</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>useTemplateMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultClientScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>optionalClientScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authorizationSettings</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">ResourceServerRepresentation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>access</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#boolean">[boolean]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>origin</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>claims</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">ApplicationRepresentation_claims</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ApplicationRepresentationClaims">ApplicationRepresentationClaims</h3>
<table class="tableblock frame-all grid-all stretch fields-ApplicationRepresentationClaims">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>username</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>profile</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>picture</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>website</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>email</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>gender</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>locale</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>address</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>phone</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="AuthDetailsRepresentation">AuthDetailsRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-AuthDetailsRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realmId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>ipAddress</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="AuthenticationExecutionExportRepresentation">AuthenticationExecutionExportRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-AuthenticationExecutionExportRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticatorConfig</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticator</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticatorFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>requirement</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>priority</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>autheticatorFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>flowAlias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userSetupAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="AuthenticationExecutionInfoRepresentation">AuthenticationExecutionInfoRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-AuthenticationExecutionInfoRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>requirement</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>alias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>requirementChoices</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>configurable</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticationFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticationConfig</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>flowId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>level</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>index</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="AuthenticationExecutionRepresentation">AuthenticationExecutionRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-AuthenticationExecutionRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticatorConfig</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticator</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticatorFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>requirement</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>priority</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>autheticatorFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>flowId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>parentFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="AuthenticationFlowRepresentation">AuthenticationFlowRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-AuthenticationFlowRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>alias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>topLevel</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>builtIn</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticationExecutions</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#AuthenticationExecutionExportRepresentation">AuthenticationExecutionExportRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="AuthenticatorConfigInfoRepresentation">AuthenticatorConfigInfoRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-AuthenticatorConfigInfoRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>helpText</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>properties</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ConfigPropertyRepresentation">ConfigPropertyRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="AuthenticatorConfigRepresentation">AuthenticatorConfigRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-AuthenticatorConfigRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>alias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="Authorization">Authorization</h3>
<table class="tableblock frame-all grid-all stretch fields-Authorization">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>permissions</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#Permission">Permission</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="CertificateRepresentation">CertificateRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-CertificateRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>privateKey</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>publicKey</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>certificate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>kid</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClaimRepresentation">ClaimRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClaimRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>username</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>profile</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>picture</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>website</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>email</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>gender</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>locale</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>address</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>phone</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientInitialAccessCreatePresentation">ClientInitialAccessCreatePresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientInitialAccessCreatePresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>expiration</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>count</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientInitialAccessPresentation">ClientInitialAccessPresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientInitialAccessPresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>token</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>timestamp</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>expiration</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>count</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>remainingCount</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientMappingsRepresentation">ClientMappingsRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientMappingsRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>client</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>mappings</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#RoleRepresentation">RoleRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientPoliciesRepresentation">ClientPoliciesRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientPoliciesRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>policies</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ClientPolicyRepresentation">ClientPolicyRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientPolicyConditionRepresentation">ClientPolicyConditionRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientPolicyConditionRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>condition</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>configuration</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientPolicyExecutorRepresentation">ClientPolicyExecutorRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientPolicyExecutorRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>executor</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>configuration</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientPolicyRepresentation">ClientPolicyRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientPolicyRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>conditions</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ClientPolicyConditionRepresentation">ClientPolicyConditionRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>profiles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientProfileRepresentation">ClientProfileRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientProfileRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>executors</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ClientPolicyExecutorRepresentation">ClientPolicyExecutorRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientProfilesRepresentation">ClientProfilesRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientProfilesRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>profiles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ClientProfileRepresentation">ClientProfileRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>globalProfiles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ClientProfileRepresentation">ClientProfileRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientRepresentation">ClientRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>rootUrl</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>adminUrl</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>baseUrl</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>surrogateAuthRequired</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>alwaysDisplayInConsole</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientAuthenticatorType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>secret</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>registrationAccessToken</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultRoles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>redirectUris</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webOrigins</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>notBefore</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>bearerOnly</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>consentRequired</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>standardFlowEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>implicitFlowEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>directAccessGrantsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>serviceAccountsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authorizationServicesEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>directGrantsOnly</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>publicClient</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>frontchannelLogout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocol</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticationFlowBindingOverrides</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>fullScopeAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>nodeReRegistrationTimeout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>registeredNodes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#integer">[integer]</a></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocolMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ProtocolMapperRepresentation">ProtocolMapperRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientTemplate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>useTemplateConfig</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>useTemplateScope</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>useTemplateMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultClientScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>optionalClientScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authorizationSettings</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">ResourceServerRepresentation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>access</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#boolean">[boolean]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>origin</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientScopeRepresentation">ClientScopeRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientScopeRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocol</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocolMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ProtocolMapperRepresentation">ProtocolMapperRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ClientTemplateRepresentation">ClientTemplateRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ClientTemplateRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocol</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>fullScopeAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>bearerOnly</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>consentRequired</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>standardFlowEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>implicitFlowEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>directAccessGrantsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>serviceAccountsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>publicClient</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>frontchannelLogout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocolMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ProtocolMapperRepresentation">ProtocolMapperRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ComponentExportRepresentation">ComponentExportRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ComponentExportRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>subType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>subComponents</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ComponentRepresentation">ComponentRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ComponentRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>parentId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>subType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ComponentTypeRepresentation">ComponentTypeRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ComponentTypeRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>helpText</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>properties</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ConfigPropertyRepresentation">ConfigPropertyRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>metadata</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#AnyType">[AnyType]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="Composites">Composites</h3>
<table class="tableblock frame-all grid-all stretch fields-Composites">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>client</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>application</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ConfigPropertyRepresentation">ConfigPropertyRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ConfigPropertyRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>label</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>helpText</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>type</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultValue</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">oas_any_type_not_mapped</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>options</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>secret</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>required</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>readOnly</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="Confirmation">Confirmation</h3>
<table class="tableblock frame-all grid-all stretch fields-Confirmation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>x5t#S256</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>jkt</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="CredentialRepresentation">CredentialRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-CredentialRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>type</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userLabel</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>createdDate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>secretData</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>credentialData</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>priority</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>value</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>temporary</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>device</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>hashedSaltedValue</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>salt</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>hashIterations</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>counter</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>algorithm</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>digits</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>period</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="DecisionEffect">DecisionEffect</h3>
<table class="tableblock frame-all grid-all stretch fields-DecisionEffect">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
</table>
</div>
<div class="sect2">
<h3 id="DecisionStrategy">DecisionStrategy</h3>
<table class="tableblock frame-all grid-all stretch fields-DecisionStrategy">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
</table>
</div>
<div class="sect2">
<h3 id="EnforcementMode">EnforcementMode</h3>
<table class="tableblock frame-all grid-all stretch fields-EnforcementMode">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
</table>
</div>
<div class="sect2">
<h3 id="EvaluationResultRepresentation">EvaluationResultRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-EvaluationResultRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resource</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">ResourceRepresentation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ScopeRepresentation">ScopeRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>policies</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#PolicyResultRepresentation">PolicyResultRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>status</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">DecisionEffect</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>allowedScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ScopeRepresentation">ScopeRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="EventRepresentation">EventRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-EventRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>time</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>type</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realmId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>sessionId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>ipAddress</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>error</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>details</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="FederatedIdentityRepresentation">FederatedIdentityRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-FederatedIdentityRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>identityProvider</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="GlobalRequestResult">GlobalRequestResult</h3>
<table class="tableblock frame-all grid-all stretch fields-GlobalRequestResult">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>successRequests</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>failedRequests</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="GroupRepresentation">GroupRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-GroupRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>path</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>parentId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>subGroupCount</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>subGroups</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#GroupRepresentation">GroupRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realmRoles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientRoles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>access</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#boolean">[boolean]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="IDToken">IDToken</h3>
<table class="tableblock frame-all grid-all stretch fields-IDToken">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>jti</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>exp</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>nbf</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>iat</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>iss</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>sub</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>typ</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>azp</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>otherClaims</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#AnyType">[AnyType]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>nonce</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>auth_time</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>session_state</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>at_hash</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>c_hash</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>given_name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>family_name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>middle_name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>nickname</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>preferred_username</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>profile</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>picture</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>website</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>email</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>email_verified</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>gender</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>birthdate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>zoneinfo</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>locale</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>phone_number</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>phone_number_verified</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>address</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">AddressClaimSet</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>updated_at</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>claims_locales</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>acr</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>s_hash</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authTime</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>sid</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="IdentityProviderMapperRepresentation">IdentityProviderMapperRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-IdentityProviderMapperRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>identityProviderAlias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>identityProviderMapper</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="IdentityProviderMapperTypeRepresentation">IdentityProviderMapperTypeRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-IdentityProviderMapperTypeRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>category</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>helpText</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>properties</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ConfigPropertyRepresentation">ConfigPropertyRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="IdentityProviderRepresentation">IdentityProviderRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-IdentityProviderRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>alias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>internalId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>updateProfileFirstLoginMode</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>trustEmail</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>storeToken</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>addReadTokenRoleOnCreate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticateByDefault</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>linkOnly</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>firstBrokerLoginFlowAlias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>postBrokerLoginFlowAlias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>updateProfileFirstLogin</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="InstallationAdapterConfig">InstallationAdapterConfig</h3>
<table class="tableblock frame-all grid-all stretch fields-InstallationAdapterConfig">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm-public-key</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>auth-server-url</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>ssl-required</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>bearer-only</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resource</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>public-client</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>verify-token-audience</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>credentials</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#AnyType">[AnyType]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>use-resource-role-mappings</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>confidential-port</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>policy-enforcer</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">PolicyEnforcerConfig</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="KeyMetadataRepresentation">KeyMetadataRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-KeyMetadataRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerPriority</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>kid</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>status</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>type</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>algorithm</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>publicKey</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>certificate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>use</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">KeyUse</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>validTo</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="KeyStoreConfig">KeyStoreConfig</h3>
<table class="tableblock frame-all grid-all stretch fields-KeyStoreConfig">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realmCertificate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>storePassword</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>keyPassword</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>keyAlias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realmAlias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>format</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="KeyUse">KeyUse</h3>
<table class="tableblock frame-all grid-all stretch fields-KeyUse">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
</table>
</div>
<div class="sect2">
<h3 id="KeysMetadataRepresentation">KeysMetadataRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-KeysMetadataRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>active</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>keys</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#KeyMetadataRepresentation">KeyMetadataRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="Logic">Logic</h3>
<table class="tableblock frame-all grid-all stretch fields-Logic">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
</table>
</div>
<div class="sect2">
<h3 id="ManagementPermissionReference">ManagementPermissionReference</h3>
<table class="tableblock frame-all grid-all stretch fields-ManagementPermissionReference">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resource</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopePermissions</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="MappingsRepresentation">MappingsRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-MappingsRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realmMappings</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#RoleRepresentation">RoleRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientMappings</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#ClientMappingsRepresentation">ClientMappingsRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="MethodConfig">MethodConfig</h3>
<table class="tableblock frame-all grid-all stretch fields-MethodConfig">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>method</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes-enforcement-mode</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">ScopeEnforcementMode</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="OAuthClientRepresentation">OAuthClientRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-OAuthClientRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>rootUrl</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>adminUrl</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>baseUrl</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>surrogateAuthRequired</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>alwaysDisplayInConsole</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientAuthenticatorType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>secret</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>registrationAccessToken</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultRoles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>redirectUris</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webOrigins</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>notBefore</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>bearerOnly</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>consentRequired</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>standardFlowEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>implicitFlowEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>directAccessGrantsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>serviceAccountsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authorizationServicesEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>directGrantsOnly</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>publicClient</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>frontchannelLogout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocol</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticationFlowBindingOverrides</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>fullScopeAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>nodeReRegistrationTimeout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>registeredNodes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#integer">[integer]</a></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocolMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ProtocolMapperRepresentation">ProtocolMapperRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientTemplate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>useTemplateConfig</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>useTemplateScope</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>useTemplateMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultClientScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>optionalClientScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authorizationSettings</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">ResourceServerRepresentation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>access</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#boolean">[boolean]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>origin</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>claims</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">ApplicationRepresentation_claims</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="PathCacheConfig">PathCacheConfig</h3>
<table class="tableblock frame-all grid-all stretch fields-PathCacheConfig">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>max-entries</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>lifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="PathConfig">PathConfig</h3>
<table class="tableblock frame-all grid-all stretch fields-PathConfig">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>type</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>path</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>methods</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#MethodConfig">MethodConfig</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enforcement-mode</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">EnforcementMode</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>claim-information-point</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#map">[map]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>invalidated</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>staticPath</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>static</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="PathSegment">PathSegment</h3>
<table class="tableblock frame-all grid-all stretch fields-PathSegment">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>path</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>matrixParameters</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="Permission">Permission</h3>
<table class="tableblock frame-all grid-all stretch fields-Permission">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>rsid</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>rsname</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>claims</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#set">[set]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="PolicyEnforcementMode">PolicyEnforcementMode</h3>
<table class="tableblock frame-all grid-all stretch fields-PolicyEnforcementMode">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
</table>
</div>
<div class="sect2">
<h3 id="PolicyEnforcerConfig">PolicyEnforcerConfig</h3>
<table class="tableblock frame-all grid-all stretch fields-PolicyEnforcerConfig">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enforcement-mode</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">EnforcementMode</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>paths</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#PathConfig">PathConfig</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>path-cache</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">PathCacheConfig</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>lazy-load-paths</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>on-deny-redirect-to</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>user-managed-access</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Object</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>claim-information-point</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#map">[map]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>http-method-as-scope</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>auth-server-url</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>credentials</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#AnyType">[AnyType]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resource</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="PolicyEvaluationRequest">PolicyEvaluationRequest</h3>
<table class="tableblock frame-all grid-all stretch fields-PolicyEvaluationRequest">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>context</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#map">[map]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resources</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ResourceRepresentation">ResourceRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>roleIds</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>entitlements</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="PolicyEvaluationResponse">PolicyEvaluationResponse</h3>
<table class="tableblock frame-all grid-all stretch fields-PolicyEvaluationResponse">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>results</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#EvaluationResultRepresentation">EvaluationResultRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>entitlements</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>status</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">DecisionEffect</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>rpt</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">AccessToken</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="PolicyProviderRepresentation">PolicyProviderRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-PolicyProviderRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>type</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>group</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="PolicyRepresentation">PolicyRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-PolicyRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>type</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>policies</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resources</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>logic</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Logic</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>decisionStrategy</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">DecisionStrategy</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>owner</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resourcesData</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#ResourceRepresentation">ResourceRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopesData</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#ScopeRepresentation">ScopeRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="PolicyResultRepresentation">PolicyResultRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-PolicyResultRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>policy</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">PolicyRepresentation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>status</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">DecisionEffect</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>associatedPolicies</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#PolicyResultRepresentation">PolicyResultRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ProtocolMapperEvaluationRepresentation">ProtocolMapperEvaluationRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ProtocolMapperEvaluationRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>mapperId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>mapperName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>containerId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>containerName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>containerType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocolMapper</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ProtocolMapperRepresentation">ProtocolMapperRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ProtocolMapperRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocol</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocolMapper</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>consentRequired</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>consentText</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="PublishedRealmRepresentation">PublishedRealmRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-PublishedRealmRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>public_key</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>token-service</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>account-service</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>tokens-not-before</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="RealmEventsConfigRepresentation">RealmEventsConfigRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-RealmEventsConfigRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>eventsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>eventsExpiration</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>eventsListeners</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabledEventTypes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>adminEventsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>adminEventsDetailsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="RealmRepresentation">RealmRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-RealmRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayNameHtml</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>notBefore</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultSignatureAlgorithm</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>revokeRefreshToken</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>refreshTokenMaxReuse</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>accessTokenLifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>accessTokenLifespanForImplicitFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>ssoSessionIdleTimeout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>ssoSessionMaxLifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>ssoSessionIdleTimeoutRememberMe</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>ssoSessionMaxLifespanRememberMe</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>offlineSessionIdleTimeout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>offlineSessionMaxLifespanEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>offlineSessionMaxLifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientSessionIdleTimeout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientSessionMaxLifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientOfflineSessionIdleTimeout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientOfflineSessionMaxLifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>accessCodeLifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>accessCodeLifespanUserAction</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>accessCodeLifespanLogin</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>actionTokenGeneratedByAdminLifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>actionTokenGeneratedByUserLifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>oauth2DeviceCodeLifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>oauth2DevicePollingInterval</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>sslRequired</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>passwordCredentialGrantAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>registrationAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>registrationEmailAsUsername</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>rememberMe</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>verifyEmail</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>loginWithEmailAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>duplicateEmailsAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resetPasswordAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>editUsernameAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userCacheEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realmCacheEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>bruteForceProtected</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>permanentLockout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>maxTemporaryLockouts</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>maxFailureWaitSeconds</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>minimumQuickLoginWaitSeconds</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>waitIncrementSeconds</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>quickLoginCheckMilliSeconds</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>maxDeltaTimeSeconds</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>failureFactor</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>privateKey</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>publicKey</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>certificate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>codeSecret</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>roles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">RolesRepresentation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>groups</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#GroupRepresentation">GroupRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultRoles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultRole</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">RoleRepresentation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultGroups</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>requiredCredentials</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>passwordPolicy</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>otpPolicyType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>otpPolicyAlgorithm</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>otpPolicyInitialCounter</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>otpPolicyDigits</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>otpPolicyLookAheadWindow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>otpPolicyPeriod</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>otpPolicyCodeReusable</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>otpSupportedApplications</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>localizationTexts</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#map">[map]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyRpEntityName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicySignatureAlgorithms</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyRpId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyAttestationConveyancePreference</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyAuthenticatorAttachment</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyRequireResidentKey</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyUserVerificationRequirement</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyCreateTimeout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyAvoidSameAuthenticatorRegister</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyAcceptableAaguids</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyExtraOrigins</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessRpEntityName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessSignatureAlgorithms</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessRpId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessAttestationConveyancePreference</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessAuthenticatorAttachment</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessRequireResidentKey</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessUserVerificationRequirement</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessCreateTimeout</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessAvoidSameAuthenticatorRegister</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessAcceptableAaguids</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>webAuthnPolicyPasswordlessExtraOrigins</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientProfiles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">ClientProfilesRepresentation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientPolicies</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">ClientPoliciesRepresentation</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>users</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#UserRepresentation">UserRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>federatedUsers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#UserRepresentation">UserRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopeMappings</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ScopeMappingRepresentation">ScopeMappingRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientScopeMappings</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clients</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ClientRepresentation">ClientRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ClientScopeRepresentation">ClientScopeRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultDefaultClientScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultOptionalClientScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>browserSecurityHeaders</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>smtpServer</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userFederationProviders</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#UserFederationProviderRepresentation">UserFederationProviderRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userFederationMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#UserFederationMapperRepresentation">UserFederationMapperRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>loginTheme</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>accountTheme</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>adminTheme</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>emailTheme</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>eventsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>eventsExpiration</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>eventsListeners</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabledEventTypes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>adminEventsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>adminEventsDetailsEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>identityProviders</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#IdentityProviderRepresentation">IdentityProviderRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>identityProviderMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#IdentityProviderMapperRepresentation">IdentityProviderMapperRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>protocolMappers</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ProtocolMapperRepresentation">ProtocolMapperRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>components</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>internationalizationEnabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>supportedLocales</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultLocale</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticationFlows</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#AuthenticationFlowRepresentation">AuthenticationFlowRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>authenticatorConfig</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#AuthenticatorConfigRepresentation">AuthenticatorConfigRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>requiredActions</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#RequiredActionProviderRepresentation">RequiredActionProviderRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>browserFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>registrationFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>directGrantFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resetCredentialsFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientAuthenticationFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>dockerAuthenticationFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>firstBrokerLoginFlow</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>keycloakVersion</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userManagedAccessAllowed</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>social</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>updateProfileOnInitialSocialLogin</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>socialProviders</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>applicationScopeMappings</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>applications</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ApplicationRepresentation">ApplicationRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>oauthClients</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#OAuthClientRepresentation">OAuthClientRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientTemplates</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ClientTemplateRepresentation">ClientTemplateRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>oAuth2DeviceCodeLifespan</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>oAuth2DevicePollingInterval</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="RequiredActionProviderRepresentation">RequiredActionProviderRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-RequiredActionProviderRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>alias</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>defaultAction</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>priority</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ResourceOwnerRepresentation">ResourceOwnerRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ResourceOwnerRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ResourceRepresentation">ResourceRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ResourceRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong><em>id</strong><br>
_optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>uris</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>type</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#ScopeRepresentation">ScopeRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>icon_uri</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>owner</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">ResourceRepresentation_owner</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>ownerManagedAccess</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>uri</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopesUma</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#ScopeRepresentation">ScopeRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ResourceRepresentationOwner">ResourceRepresentationOwner</h3>
<table class="tableblock frame-all grid-all stretch fields-ResourceRepresentationOwner">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ResourceServerRepresentation">ResourceServerRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ResourceServerRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>allowRemoteResourceManagement</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>policyEnforcementMode</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">PolicyEnforcementMode</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resources</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ResourceRepresentation">ResourceRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>policies</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#PolicyRepresentation">PolicyRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ScopeRepresentation">ScopeRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>decisionStrategy</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">DecisionStrategy</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="RoleRepresentation">RoleRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-RoleRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>description</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopeParamRequired</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>composite</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>composites</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Composites</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientRole</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>containerId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="RolesRepresentation">RolesRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-RolesRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realm</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#RoleRepresentation">RoleRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>client</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>application</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ScopeEnforcementMode">ScopeEnforcementMode</h3>
<table class="tableblock frame-all grid-all stretch fields-ScopeEnforcementMode">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
</table>
</div>
<div class="sect2">
<h3 id="ScopeMappingRepresentation">ScopeMappingRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ScopeMappingRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>self</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>client</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientTemplate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientScope</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>roles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="ScopeRepresentation">ScopeRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-ScopeRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>iconUri</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>policies</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#PolicyRepresentation">PolicyRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>resources</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#ResourceRepresentation">ResourceRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="SocialLinkRepresentation">SocialLinkRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-SocialLinkRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>socialProvider</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>socialUserId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>socialUsername</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UPAttribute">UPAttribute</h3>
<table class="tableblock frame-all grid-all stretch fields-UPAttribute">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>validations</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#map">[map]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>annotations</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#AnyType">[AnyType]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>required</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">UPAttributeRequired</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>permissions</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">UPAttributePermissions</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>selector</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">UPAttributeSelector</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>group</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>multivalued</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UPAttributePermissions">UPAttributePermissions</h3>
<table class="tableblock frame-all grid-all stretch fields-UPAttributePermissions">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>view</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>edit</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UPAttributeRequired">UPAttributeRequired</h3>
<table class="tableblock frame-all grid-all stretch fields-UPAttributeRequired">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>roles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UPAttributeSelector">UPAttributeSelector</h3>
<table class="tableblock frame-all grid-all stretch fields-UPAttributeSelector">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>scopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UPConfig">UPConfig</h3>
<table class="tableblock frame-all grid-all stretch fields-UPConfig">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#UPAttribute">UPAttribute</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>groups</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#UPGroup">UPGroup</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>unmanagedAttributePolicy</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">UnmanagedAttributePolicy</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UPGroup">UPGroup</h3>
<table class="tableblock frame-all grid-all stretch fields-UPGroup">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayHeader</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayDescription</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>annotations</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#AnyType">[AnyType]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UnmanagedAttributePolicy">UnmanagedAttributePolicy</h3>
<table class="tableblock frame-all grid-all stretch fields-UnmanagedAttributePolicy">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
</table>
</div>
<div class="sect2">
<h3 id="UserConsentRepresentation">UserConsentRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-UserConsentRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>grantedClientScopes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>createdDate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>lastUpdatedDate</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>grantedRealmRoles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UserFederationMapperRepresentation">UserFederationMapperRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-UserFederationMapperRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>federationProviderDisplayName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>federationMapperType</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UserFederationProviderRepresentation">UserFederationProviderRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-UserFederationProviderRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>providerName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>config</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>priority</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>fullSyncPeriod</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>changedSyncPeriod</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>lastSync</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UserProfileAttributeGroupMetadata">UserProfileAttributeGroupMetadata</h3>
<table class="tableblock frame-all grid-all stretch fields-UserProfileAttributeGroupMetadata">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayHeader</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayDescription</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>annotations</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#AnyType">[AnyType]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UserProfileAttributeMetadata">UserProfileAttributeMetadata</h3>
<table class="tableblock frame-all grid-all stretch fields-UserProfileAttributeMetadata">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>name</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>displayName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>required</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>readOnly</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>annotations</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#AnyType">[AnyType]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>validators</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#map">[map]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>group</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>multivalued</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UserProfileMetadata">UserProfileMetadata</h3>
<table class="tableblock frame-all grid-all stretch fields-UserProfileMetadata">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#UserProfileAttributeMetadata">UserProfileAttributeMetadata</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>groups</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#UserProfileAttributeGroupMetadata">UserProfileAttributeGroupMetadata</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UserRepresentation">UserRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-UserRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>username</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>firstName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>lastName</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>email</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>emailVerified</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>attributes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userProfileMetadata</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">UserProfileMetadata</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>self</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>origin</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>createdTimestamp</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>enabled</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>totp</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>federationLink</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>serviceAccountClientId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>credentials</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#CredentialRepresentation">CredentialRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>disableableCredentialTypes</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Set  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>requiredActions</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>federatedIdentities</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#FederatedIdentityRepresentation">FederatedIdentityRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>realmRoles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientRoles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clientConsents</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#UserConsentRepresentation">UserConsentRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>notBefore</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Integer</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int32</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>applicationRoles</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#array">[array]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>socialLinks</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#SocialLinkRepresentation">SocialLinkRepresentation</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>groups</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">List  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>access</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#boolean">[boolean]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="UserSessionRepresentation">UserSessionRepresentation</h3>
<table class="tableblock frame-all grid-all stretch fields-UserSessionRepresentation">
<colgroup>
<col style="width: 40%;">
<col style="width: 40%;">
<col style="width: 20%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Name</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Format</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>id</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>username</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>userId</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>ipAddress</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">String</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>start</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>lastAccess</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Long</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">int64</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>rememberMe</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Boolean</p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><strong>clients</strong><br>
<em>optional</em></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Map  of <a href="#string">[string]</a></p></td>
<td class="tableblock halign-left valign-top"></td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
</div>
<div id="footer">
<div id="footer-text">
Last updated 2024-03-24 22:16:31 UTC
</div>
</div>
