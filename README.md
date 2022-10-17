плагин генерит файлы в каталог specification<br>
<br>по умолчанию файл [specification]build.gradle.kts генерится со старыми версиями библиотек
<br>чтобы можно было в ручную указать версии библиотек, [specification]build.gradle.kts вписан в файл openapi-generator-ignore
<br>файлы вписанные в openapi-generator-ignore при генерации не удаляются 

настройки плагина openapi-generator прописаны в [root]build.gradle.kts
<br>swagger файл лежит в [root]resources/openapi/openapi.yml