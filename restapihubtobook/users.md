# Users

{% hint style="info" %}
**Good to know:** All the methods shown below are synced to an example Swagger file URL and are kept up to date automatically with changes to the API.
{% endhint %}

## User actions

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/user/login" method="get" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/user/logout" method="get" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

## Creating users

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/user/createWithList" method="post" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/user/createWithArray" method="post" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

|   |   |   |
| - | - | - |
|   |   |   |
|   |   |   |
|   |   |   |



{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/pet/{petId}/uploadImage" method="post" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/pet" method="put" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/pet/findByStatus" method="get" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/pet/findByTags" method="get" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/pet/{petId}" method="get" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/user/createWithArray" method="post" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/user/createWithList" method="post" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/user/{username}" method="get" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/user/{username}" method="put" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}


## Create a new user
|   |   |   |
| - | - | - |
|   |   |   |
|   |   |   |
|   |   |   |

{% swagger src="https://petstore.swagger.io/v2/swagger.json" path="/user1/{username}" method="put" %}
[https://petstore.swagger.io/v2/swagger.json](https://petstore.swagger.io/v2/swagger.json)
{% endswagger %}

<mark style="color:green;">`POST`</mark> http://localhost:8080`/users`

`POST`[`Htps://petstore.swagger.io/v2/user/{username}`](https://petstore.swagger.io/v2/user/%7Busername%7D)

[https://petstore.swagger.io/v2/user/{username}](https://petstore.swagger.io/v2/user/%7Busername%7D)

**Headers**

| Name          | Value              |
| ------------- | ------------------ |
| Content-Type  | `application/json` |
| Authorization | `Bearer <token>`   |

**Body**

| Name   | Type   | Description      |
| ------ | ------ | ---------------- |
| `name` | string | Name of the user |
| `age`  | number | Age of the user  |

**Response**

{% tabs %}
{% tab title="200" %}
```json
{
  "id": 1,
  "name": "John",
  "age": 30
}
```
{% endtab %}

{% tab title="400" %}
```json
{
  "error": "Invalid request"
}
```
{% endtab %}

{% tab title="Untitled" %}
```
// Some codedd
```
{% endtab %}

{% tab title="Untitled" %}
sdfadsf
{% endtab %}
{% endtabs %}
