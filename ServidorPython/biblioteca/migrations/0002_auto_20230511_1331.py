# Generated by Django 3.2.18 on 2023-05-11 19:31

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('biblioteca', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='libro',
            name='descripcion',
            field=models.CharField(max_length=1500),
        ),
        migrations.AlterField(
            model_name='libro',
            name='editorial',
            field=models.CharField(max_length=100),
        ),
    ]